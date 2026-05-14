package com.example.prathamchikitse.ui.aicheck

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.prathamchikitse.data.remote.GeminiApiClient
import com.example.prathamchikitse.data.remote.GeminiContent
import com.example.prathamchikitse.data.remote.GeminiGenerateRequest
import com.example.prathamchikitse.data.remote.GeminiGenerateResponse
import com.example.prathamchikitse.data.remote.GeminiInstruction
import com.example.prathamchikitse.data.remote.GeminiPart
import com.example.prathamchikitse.databinding.FragmentAiCheckBinding
import com.example.prathamchikitse.language.AppLanguage
import com.example.prathamchikitse.language.LanguageAwareScreen
import com.example.prathamchikitse.language.LanguageManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AiCheckFragment : Fragment(), LanguageAwareScreen {

    private var _binding: FragmentAiCheckBinding? = null
    private val binding get() = _binding!!
    private var currentLanguage: AppLanguage = AppLanguage.ENGLISH
    private val modelFallbacks = listOf(
        "gemini-1.5-flash-latest",
        "gemini-1.5-flash",
        "gemini-2.0-flash"
    )
    private val aiPrompt =
        "You are a first aid emergency assistant. " +
            "Choose ONLY one most likely emergency from this fixed list: " +
            "Snake Bite, Heart Attack, Choking, Burns, Fracture, Drowning, Electric Shock, Poisoning, Fever, Bleeding, Eye Injury, Allergic Reaction, Fainting, Seizure, Nosebleed, Sprain, Dog Bite, Head Injury, Asthma Attack, Diabetic Emergency. " +
            "Respond in exactly 3 short lines in this format: " +
            "Emergency: <one item from list>. " +
            "First step: <single most important first step>. " +
            "Call 108 immediately if serious."

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAiCheckBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        currentLanguage = LanguageManager.getSelectedLanguage(requireContext())
        applyLanguage(currentLanguage)

        binding.checkButton.setOnClickListener {
            val symptoms = binding.symptomsInput.text.toString().trim()
            if (symptoms.isBlank()) {
                binding.responseText.text = if (currentLanguage == AppLanguage.KANNADA) {
                    "ದಯವಿಟ್ಟು ಲಕ್ಷಣಗಳನ್ನು ಬರೆಯಿರಿ."
                } else {
                    "Please enter your symptoms."
                }
                return@setOnClickListener
            }
            callGemini(symptoms)
        }
    }

    private fun callGemini(symptoms: String) {
        val fastPath = buildHighConfidenceSuggestion(symptoms)
        if (fastPath != null) {
            binding.responseText.text = fastPath
            return
        }

        showLoading(true)
        val request = GeminiGenerateRequest(
            systemInstruction = GeminiInstruction(
                parts = listOf(
                    GeminiPart(
                        text = aiPrompt
                    )
                )
            ),
            contents = listOf(
                GeminiContent(
                    role = "user",
                    parts = listOf(GeminiPart(text = symptoms))
                )
            )
        )

        requestWithModelFallback(request, symptoms, modelIndex = 0)
    }

    private fun requestWithModelFallback(
        request: GeminiGenerateRequest,
        symptoms: String,
        modelIndex: Int
    ) {
        val model = modelFallbacks.getOrNull(modelIndex)
        if (model == null) {
            showLoading(false)
            binding.responseText.text = buildOfflineSuggestion(symptoms)
            return
        }

        GeminiApiClient.service.generateContent(
            model,
            GeminiApiClient.API_KEY,
            request
        ).enqueue(object : Callback<GeminiGenerateResponse> {
            override fun onResponse(
                call: Call<GeminiGenerateResponse>,
                response: Response<GeminiGenerateResponse>
            ) {
                if (!response.isSuccessful && (response.code() == 404 || response.code() == 400)) {
                    requestWithModelFallback(request, symptoms, modelIndex + 1)
                    return
                }

                if (response.code() == 429) {
                    showLoading(false)
                    binding.responseText.text = buildOfflineSuggestion(symptoms)
                    return
                }

                showLoading(false)
                val text = response.body()?.candidates
                    ?.firstOrNull()
                    ?.content
                    ?.parts
                    ?.firstOrNull()
                    ?.text
                    ?.trim()
                binding.responseText.text = if (response.isSuccessful && !text.isNullOrEmpty()) {
                    text
                } else {
                    val errorText = response.errorBody()?.string()?.takeIf { it.isNotBlank() }
                    if (!errorText.isNullOrBlank()) {
                        formatApiError(errorText)
                    } else {
                        getPleaseTryAgainText()
                    }
                }
            }

            override fun onFailure(call: Call<GeminiGenerateResponse>, t: Throwable) {
                showLoading(false)
                binding.responseText.text = buildOfflineSuggestion(symptoms)
            }
        })
    }

    private fun showLoading(isLoading: Boolean) {
        binding.loadingProgress.visibility = if (isLoading) View.VISIBLE else View.GONE
        binding.checkButton.isEnabled = !isLoading
    }

    override fun onLanguageChanged(language: AppLanguage) {
        currentLanguage = language
        if (_binding != null) {
            applyLanguage(language)
        }
    }

    private fun applyLanguage(language: AppLanguage) {
        if (language == AppLanguage.KANNADA) {
            binding.aiTitleText.text = "AI ಲಕ್ಷಣ ಪರಿಶೀಲಕ"
            binding.symptomsInput.hint = "ನಿಮ್ಮ ಲಕ್ಷಣಗಳನ್ನು ಇಲ್ಲಿ ಬರೆಯಿರಿ..."
            binding.checkButton.text = "ಪರಿಶೀಲಿಸಿ"
            binding.responseText.text = "AI ಸಲಹೆ ಇಲ್ಲಿ ಕಾಣಿಸುತ್ತದೆ."
        } else {
            binding.aiTitleText.text = "AI Symptom Checker"
            binding.symptomsInput.hint = "Describe your symptoms here..."
            binding.checkButton.text = "Check"
            binding.responseText.text = "AI suggestion will appear here."
        }
    }

    private fun getPleaseTryAgainText(): String {
        return if (currentLanguage == AppLanguage.KANNADA) "ದಯವಿಟ್ಟು ಮತ್ತೆ ಪ್ರಯತ್ನಿಸಿ" else "Please try again"
    }

    private fun formatApiError(rawError: String): String {
        val short = rawError.replace("\n", " ").take(220)
        return if (currentLanguage == AppLanguage.KANNADA) {
            "ದಯವಿಟ್ಟು ಮತ್ತೆ ಪ್ರಯತ್ನಿಸಿ.\n$short"
        } else {
            "Please try again.\n$short"
        }
    }

    private fun buildOfflineSuggestion(symptoms: String): String {
        val text = symptoms.lowercase()
        val (emergency, firstStep) = when {
            text.contains("chest pain") || text.contains("chest tight") || text.contains("left arm") ->
                "Heart Attack" to "Make the person sit upright and call emergency medical help immediately."
            text.contains("breath") || text.contains("wheez") || text.contains("asthma") ->
                "Asthma Attack" to "Help the person sit up and use a quick-relief inhaler right away."
            text.contains("bleed") || text.contains("blood") ->
                "Bleeding" to "Apply firm direct pressure with a clean cloth continuously."
            text.contains("burn") || text.contains("hot water") || text.contains("fire") ->
                "Burns" to "Cool the burn under running cool water for at least 20 minutes."
            text.contains("faint") || text.contains("passed out") || text.contains("unconscious") ->
                "Fainting" to "Lay the person flat and raise the legs slightly."
            text.contains("seizure") || text.contains("fits") || text.contains("convulsion") ->
                "Seizure" to "Protect from injury and do not put anything in the mouth."
            else -> "Fever" to "Keep hydrated, rest, and monitor warning signs closely."
        }

        return if (currentLanguage == AppLanguage.KANNADA) {
            "AI ತಾತ್ಕಾಲಿಕವಾಗಿ ಲಭ್ಯವಿಲ್ಲ (quota ಮಿತಿ). ಹತ್ತಿರವಾದ ಪರಿಸ್ಥಿತಿ: $emergency.\n" +
                "ಮೊದಲ ಮುಖ್ಯ ಕ್ರಮ: $firstStep\n" +
                "ಗಂಭೀರವಾಗಿದ್ದರೆ ತಕ್ಷಣ 108ಕ್ಕೆ ಕರೆ ಮಾಡಿ."
        } else {
            "AI is temporarily unavailable (quota limit). Most likely emergency: $emergency.\n" +
                "First important step: $firstStep\n" +
                "Call 108 immediately if serious."
        }
    }

    private fun buildHighConfidenceSuggestion(symptoms: String): String? {
        val s = symptoms.lowercase()
        val result = when {
            s.contains("chest pain") || s.contains("left arm pain") || s.contains("crushing pain") ->
                "Heart Attack" to "Make the person sit upright and call emergency help immediately."
            s.contains("can't breathe") || s.contains("cannot breathe") || s.contains("throat blocked") || s.contains("choking") ->
                "Choking" to "Give 5 back blows immediately if severe blockage is present."
            s.contains("seizure") || s.contains("fits") || s.contains("convulsion") ->
                "Seizure" to "Protect from injury and do not put anything in the mouth."
            s.contains("electric shock") || s.contains("current") || s.contains("electrocut") ->
                "Electric Shock" to "Turn off power source before touching the person."
            s.contains("poison") || s.contains("overdose") || s.contains("chemical swallowed") ->
                "Poisoning" to "Call poison/emergency support immediately and keep airway clear."
            s.contains("snake bite") || s.contains("snakebite") ->
                "Snake Bite" to "Keep the bitten limb still and transport urgently."
            s.contains("burn") || s.contains("scald") || s.contains("fire injury") ->
                "Burns" to "Cool the burn under running cool water for at least 20 minutes."
            s.contains("bleeding heavily") || s.contains("heavy bleeding") || s.contains("blood loss") ->
                "Bleeding" to "Apply firm direct pressure continuously with a clean cloth."
            else -> null
        } ?: return null

        val (emergency, firstStep) = result
        return "Emergency: $emergency.\nFirst step: $firstStep\nCall 108 immediately if serious."
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

