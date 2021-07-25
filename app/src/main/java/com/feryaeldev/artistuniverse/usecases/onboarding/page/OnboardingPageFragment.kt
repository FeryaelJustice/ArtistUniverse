package com.feryaeldev.artistuniverse.usecases.onboarding.page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.feryaeldev.artistuniverse.databinding.FragmentOnboardingPageBinding
import com.feryaeldev.artistuniverse.model.domain.OnboardingPage
import com.google.gson.Gson

class OnboardingPageFragment : Fragment() {

    companion object {
        private const val PAGE = "PAGE"

        @JvmStatic
        fun fragment(page: OnboardingPage) = OnboardingPageFragment().apply {
            arguments = Bundle().apply {
                putString(PAGE, Gson().toJson(page))
            }
        }
    }

    private var _binding: FragmentOnboardingPageBinding? = null
    private val binding get() = _binding!!

    private val page: OnboardingPage? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardingPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}