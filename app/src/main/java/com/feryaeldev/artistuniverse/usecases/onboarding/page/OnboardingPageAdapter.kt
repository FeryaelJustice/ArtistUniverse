package com.feryaeldev.artistuniverse.usecases.onboarding.page

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.feryaeldev.artistuniverse.model.domain.OnboardingPage

class OnboardingPageAdapter(
    private val context: AppCompatActivity,
    var pages: List<OnboardingPage>
) :
    FragmentStateAdapter(context) {

    override fun getItemCount(): Int = pages.size

    override fun createFragment(position: Int): Fragment {
        val page = pages[position]
        return OnboardingPageFragment.fragment(page)
    }
}