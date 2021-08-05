package com.feryaeldev.artistuniverse.usecases.launch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.feryaeldev.artistuniverse.databinding.ActivityLaunchBinding
import com.feryaeldev.artistuniverse.model.session.Session
import com.feryaeldev.artistuniverse.usecases.home.HomeRouter
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize

class LaunchActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLaunchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaunchBinding.inflate(layoutInflater)

        // Content
        setContentView(binding.root)

        // Setup
        setup()
    }

    private fun setup() {

        supportActionBar?.hide()

        Firebase.initialize(applicationContext)

        // Session
        Session.instance.configure(applicationContext)
        showHome()
    }

    private fun showHome() {
        HomeRouter().launch(applicationContext)
        finish()
    }
}