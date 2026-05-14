package com.example.prathamchikitse.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.prathamchikitse.databinding.FragmentDoDontPageBinding

class DoDontPageFragment : Fragment() {

    private var _binding: FragmentDoDontPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDoDontPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dos = requireArguments().getStringArrayList(ARG_DOS).orEmpty()
        val donts = requireArguments().getStringArrayList(ARG_DONTS).orEmpty()
        binding.dosText.text = dos.joinToString(separator = "\n") { "- $it" }
        binding.dontsText.text = donts.joinToString(separator = "\n") { "- $it" }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_DOS = "arg_dos"
        private const val ARG_DONTS = "arg_donts"

        fun newInstance(dos: List<String>, donts: List<String>): DoDontPageFragment {
            return DoDontPageFragment().apply {
                arguments = Bundle().apply {
                    putStringArrayList(ARG_DOS, ArrayList(dos))
                    putStringArrayList(ARG_DONTS, ArrayList(donts))
                }
            }
        }
    }
}
