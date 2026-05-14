package com.example.prathamchikitse.ui.hospital

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prathamchikitse.databinding.FragmentHospitalFinderBinding
import com.example.prathamchikitse.language.AppLanguage
import com.example.prathamchikitse.language.LanguageAwareScreen
import com.example.prathamchikitse.language.LanguageManager

class HospitalFinderFragment : Fragment(), LanguageAwareScreen {

    private var _binding: FragmentHospitalFinderBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HospitalFinderViewModel by viewModels()
    private lateinit var hospitalAdapter: HospitalAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHospitalFinderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hospitalAdapter = HospitalAdapter()
        binding.hospitalRecyclerView.apply {
            adapter = hospitalAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        viewModel.hospitals.observe(viewLifecycleOwner) {
            hospitalAdapter.submitList(it)
        }
        onLanguageChanged(LanguageManager.getSelectedLanguage(requireContext()))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onLanguageChanged(language: AppLanguage) {
        if (_binding == null) return
        binding.hospitalTitleText.text = if (language == AppLanguage.KANNADA) {
            "ಹತ್ತಿರದ ಆಸ್ಪತ್ರೆಗಳು (ಸ್ಥಿರ ಪಟ್ಟಿ)"
        } else {
            "Nearby Hospitals (Static List)"
        }
        viewModel.loadHospitals(language)
    }
}
