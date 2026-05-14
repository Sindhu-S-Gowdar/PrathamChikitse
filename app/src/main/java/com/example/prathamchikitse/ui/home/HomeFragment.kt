package com.example.prathamchikitse.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.prathamchikitse.databinding.FragmentHomeBinding
import com.example.prathamchikitse.language.AppLanguage
import com.example.prathamchikitse.language.LanguageAwareScreen
import com.example.prathamchikitse.language.LanguageManager
import com.example.prathamchikitse.ui.detail.EmergencyDetailActivity

class HomeFragment : Fragment(), LanguageAwareScreen {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var emergencyAdapter: EmergencyAdapter
    private var currentLanguage: AppLanguage = AppLanguage.ENGLISH

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        currentLanguage = LanguageManager.getSelectedLanguage(requireContext())

        emergencyAdapter = EmergencyAdapter { selectedEmergency ->
            val detailIntent = Intent(requireContext(), EmergencyDetailActivity::class.java)
            detailIntent.putExtra(EmergencyDetailActivity.EXTRA_EMERGENCY_ID, selectedEmergency.id)
            startActivity(detailIntent)
        }

        binding.emergencyRecyclerView.apply {
            adapter = emergencyAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
        }

        viewModel.emergencies.observe(viewLifecycleOwner) {
            emergencyAdapter.submitList(it)
        }
        applyLanguage(currentLanguage)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onLanguageChanged(language: AppLanguage) {
        currentLanguage = language
        if (_binding != null) {
            applyLanguage(language)
        }
    }

    private fun applyLanguage(language: AppLanguage) {
        binding.homeTitleText.text = if (language == AppLanguage.KANNADA) {
            "ತುರ್ತು ಪ್ರಥಮ ಚಿಕಿತ್ಸೆ ಮಾರ್ಗದರ್ಶಿ"
        } else {
            "Emergency First Aid Guide"
        }
        binding.homeSubtitleText.text = if (language == AppLanguage.KANNADA) {
            "ಪ್ರಥಮ-ಚಿಕಿತ್ಸೆ (ಆಫ್‌ಲೈನ್) - ಲಾಗಿನ್ ಅಗತ್ಯವಿಲ್ಲ"
        } else {
            "Pratham-Chikitse (Offline) - No login required"
        }
        viewModel.loadEmergencies(language)
    }
}
