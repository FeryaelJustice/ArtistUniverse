package com.feryaeldev.artistuniverse.usecases.common.controls

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.feryaeldev.artistuniverse.databinding.FragmentProgressBarBinding

class ProgressBarFragment : Fragment() {

    private var _binding: FragmentProgressBarBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProgressBarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = ProgressBarFragment()
    }
}