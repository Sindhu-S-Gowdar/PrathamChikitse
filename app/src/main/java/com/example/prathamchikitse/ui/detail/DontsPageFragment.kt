package com.example.prathamchikitse.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.prathamchikitse.databinding.FragmentDontsPageBinding

class DontsPageFragment : Fragment() {

    private var _binding: FragmentDontsPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDontsPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val donts = requireArguments().getStringArrayList(ARG_DONTS).orEmpty()
        binding.dontsText.text = donts.joinToString(separator = "\n") { "- $it" }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_DONTS = "arg_donts"

        fun newInstance(donts: List<String>): DontsPageFragment {
            return DontsPageFragment().apply {
                arguments = Bundle().apply {
                    putStringArrayList(ARG_DONTS, ArrayList(donts))
                }
            }
        }
    }
}

