package com.feryaeldev.artistuniverse.usecases.onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.feryaeldev.artistuniverse.R
import com.feryaeldev.artistuniverse.databinding.ActivityOnboardingBinding

class OnboardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingBinding

    private lateinit var viewModel: OnboardingViewModel

    private var selection = 0
    private var dots: Array<TextView?> = arrayOfNulls(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        viewModel = ViewModelProvider(this).get(OnboardingViewModel::class.java)

        localize()
        setup()
    }

    private fun localize() {
        TODO("Not yet implemented")
    }

    private fun setup() {
        TODO("Not yet implemented")
    }
}