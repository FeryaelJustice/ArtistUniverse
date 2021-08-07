package com.feryaeldev.artistuniverse.util.extension

import android.os.Build
import com.feryaeldev.artistuniverse.util.Constants
import java.text.SimpleDateFormat
import java.util.*

fun String.toDate(): Date? {
    var formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:ZZZ", Locale.getDefault())
    formatter.timeZone = TimeZone.getTimeZone("UTC")
    var date = formatter.parse(this)
    if (date == null) {
        formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:ZZZ", Constants.DEFAULT_LOCALE)
        formatter.timeZone = TimeZone.getTimeZone("UTC")
        date = formatter.parse(this)
    }
    return date
}

fun String.toRFC3339Date(): Date? {
    val formatter = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX", Constants.DEFAULT_LOCALE)
    } else {
        SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Constants.DEFAULT_LOCALE)
    }
    formatter.timeZone = TimeZone.getTimeZone("UTC")
    return formatter.parse(this)
}

fun String.uppercaseFirst(): String = this.replaceFirstChar { it.uppercase() }

fun String.removeFirebaseInvalidCharacters(): String {
    return replace(".", "")
        .replace("#", "")
        .replace("$", "")
        .replace("[", "")
        .replace("]", "")
}