package com.feryaeldev.artistuniverse.usecases.onboarding

import androidx.lifecycle.ViewModel
import com.feryaeldev.artistuniverse.R
import com.feryaeldev.artistuniverse.model.OnboardingPage

class OnboardingViewModel: ViewModel() {

    // Properties

    val data = arrayListOf(
        OnboardingPage(0, R.drawable.ic_launcher_foreground,R.string.onboarding_page0_title,R.string.onboarding_page0_body)
    )

    val pages = data.size

    // Localization

    val understoodText = R.string.understood
    val previousText = R.string.previous
    val nextText = R.string.next

    // Public

}