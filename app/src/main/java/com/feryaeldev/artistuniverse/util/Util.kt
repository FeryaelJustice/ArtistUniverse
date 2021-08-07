package com.feryaeldev.artistuniverse.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.DisplayMetrics
import com.feryaeldev.artistuniverse.BuildConfig
import java.io.UnsupportedEncodingException
import java.net.URLEncoder

object Util {

    fun openBrowser(context: Context, url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(intent)
    }


    fun urlEncode(url: String): String? {
        return try {
            URLEncoder.encode(url, "UTF-8")
        } catch (e: UnsupportedEncodingException) {
            return null
        }
    }

    fun version(): String = "${BuildConfig.VERSION_NAME} (${BuildConfig.VERSION_CODE})"

    fun dpToPixel(context: Context, dp: Int): Float {
        return dp * (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }
}