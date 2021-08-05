package com.feryaeldev.artistuniverse.usecases.launch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import com.feryaeldev.artistuniverse.R
import com.feryaeldev.artistuniverse.usecases.onboarding.OnboardingActivity

class LaunchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        startActivity(Intent(applicationContext,OnboardingActivity::class.java)).apply {
            finish()
        }
    }
}