package com.example.prathamchikitse.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.prathamchikitse.databinding.FragmentStepPageBinding

class StepPageFragment : Fragment() {

    private var _binding: FragmentStepPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStepPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val stepNumber = requireArguments().getInt(ARG_STEP_NUMBER)
        val stepText = requireArguments().getString(ARG_STEP_TEXT).orEmpty()
        binding.stepTitleText.text = "Step $stepNumber"
        binding.stepDescriptionText.text = stepText
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_STEP_NUMBER = "arg_step_number"
        private const val ARG_STEP_TEXT = "arg_step_text"

        fun newInstance(stepNumber: Int, stepText: String): StepPageFragment {
            return StepPageFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_STEP_NUMBER, stepNumber)
                    putString(ARG_STEP_TEXT, stepText)
                }
            }
        }
    }
}
