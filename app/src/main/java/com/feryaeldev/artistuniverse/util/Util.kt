package com.feryaeldev.artistuniverse.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.feryaeldev.artistuniverse.BuildConfig

object Util {

    fun openBrowser(context: Context, url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(intent)
    }

    fun version(): String = "${BuildConfig.VERSION_NAME} (${BuildConfig.VERSION_CODE})"
}