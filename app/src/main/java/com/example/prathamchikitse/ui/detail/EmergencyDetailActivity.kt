package com.example.prathamchikitse.ui.detail

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.prathamchikitse.databinding.ActivityEmergencyDetailBinding
import com.example.prathamchikitse.language.AppLanguage
import com.example.prathamchikitse.language.LanguageManager

class EmergencyDetailActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    private lateinit var binding: ActivityEmergencyDetailBinding
    private val viewModel: EmergencyDetailViewModel by viewModels()
    private var textToSpeech: TextToSpeech? = null
    private var isTtsReady = false
    private var pendingNarration: String? = null
    private lateinit var emergencyId: String
    private var currentLanguage: AppLanguage = AppLanguage.ENGLISH

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmergencyDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        emergencyId = intent.getStringExtra(EXTRA_EMERGENCY_ID).orEmpty()
        currentLanguage = LanguageManager.getSelectedLanguage(this)
        binding.languageToggleButton.text = LanguageManager.getToggleButtonText(currentLanguage)
        updateStaticLabels(currentLanguage)
        viewModel.loadGuide(emergencyId, currentLanguage)

        binding.backButton.setOnClickListener { finish() }
        binding.languageToggleButton.setOnClickListener {
            currentLanguage = LanguageManager.toggleLanguage(this)
            binding.languageToggleButton.text = LanguageManager.getToggleButtonText(currentLanguage)
            updateStaticLabels(currentLanguage)
            updateTtsLanguage()
            viewModel.loadGuide(emergencyId, currentLanguage)
        }

        viewModel.guide.observe(this) { guide ->
            if (guide == null) {
                finish()
                return@observe
            }
            binding.titleText.text = guide.title
            binding.allStepsText.text = guide.steps
                .mapIndexed { index, step ->
                    val stepPrefix = if (currentLanguage == AppLanguage.KANNADA) "ಹಂತ" else "Step"
                    "$stepPrefix ${index + 1}: $step"
                }
                .joinToString(separator = "\n\n")
            binding.allDosText.text = guide.dos.joinToString(separator = "\n") { "- $it" }
            binding.allDontsText.text = guide.donts.joinToString(separator = "\n") { "- $it" }

            binding.audioButton.setOnClickListener {
                val narration = buildString {
                    append(if (currentLanguage == AppLanguage.KANNADA) "ಹಂತಗಳು. " else "Steps. ")
                    guide.steps.forEachIndexed { index, step ->
                        if (currentLanguage == AppLanguage.KANNADA) {
                            append("ಹಂತ ${index + 1}. $step. ")
                        } else {
                            append("Step ${index + 1}. $step. ")
                        }
                    }
                    append(if (currentLanguage == AppLanguage.KANNADA) "ಮಾಡಬೇಕಾದವು. " else "Do's. ")
                    guide.dos.forEach { append("$it. ") }
                    append(if (currentLanguage == AppLanguage.KANNADA) "ಮಾಡಬಾರದವು. " else "Don'ts. ")
                    guide.donts.forEach { append("$it. ") }
                }

                // Lazily init TTS to avoid UI freezes on some emulators/devices.
                if (textToSpeech == null) {
                    pendingNarration = narration
                    val preparing = if (currentLanguage == AppLanguage.KANNADA) {
                        "ಆಡಿಯೋ ಸಿದ್ಧಗೊಳ್ಳುತ್ತಿದೆ..."
                    } else {
                        "Preparing audio..."
                    }
                    Toast.makeText(this, preparing, Toast.LENGTH_SHORT).show()
                    textToSpeech = TextToSpeech(this, this)
                    return@setOnClickListener
                }

                if (!isTtsReady) {
                    pendingNarration = narration
                    val notReady = if (currentLanguage == AppLanguage.KANNADA) {
                        "ಆಡಿಯೋ ಇನ್ನೂ ಸಿದ್ಧವಾಗಿಲ್ಲ."
                    } else {
                        "Audio is not ready yet."
                    }
                    Toast.makeText(this, notReady, Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                textToSpeech?.speak(narration, TextToSpeech.QUEUE_FLUSH, null, guide.id)
            }
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = textToSpeech?.setLanguage(LanguageManager.localeFor(currentLanguage))
            isTtsReady = result != TextToSpeech.LANG_MISSING_DATA &&
                result != TextToSpeech.LANG_NOT_SUPPORTED

            val queued = pendingNarration
            if (isTtsReady && !queued.isNullOrBlank()) {
                pendingNarration = null
                textToSpeech?.speak(queued, TextToSpeech.QUEUE_FLUSH, null, "queued_narration")
            }
        }
    }

    override fun onDestroy() {
        textToSpeech?.stop()
        textToSpeech?.shutdown()
        super.onDestroy()
    }

    private fun updateTtsLanguage() {
        if (textToSpeech == null) return
        val result = textToSpeech?.setLanguage(LanguageManager.localeFor(currentLanguage))
        isTtsReady = result != TextToSpeech.LANG_MISSING_DATA &&
            result != TextToSpeech.LANG_NOT_SUPPORTED
    }

    private fun updateStaticLabels(language: AppLanguage) {
        binding.dosHeaderText.text = if (language == AppLanguage.KANNADA) "ಮಾಡಬೇಕಾದವು" else "Do's"
        binding.dontsHeaderText.text = if (language == AppLanguage.KANNADA) "ಮಾಡಬಾರದವು" else "Don'ts"
        binding.audioButton.text = if (language == AppLanguage.KANNADA) {
            "ಆಡಿಯೋ ಸೂಚನೆಗಳನ್ನು ಕೇಳಿ"
        } else {
            "Play Audio Instructions"
        }
    }

    companion object {
        const val EXTRA_EMERGENCY_ID = "extra_emergency_id"
    }
}
