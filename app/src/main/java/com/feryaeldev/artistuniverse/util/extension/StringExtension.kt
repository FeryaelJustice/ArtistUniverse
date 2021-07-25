package com.feryaeldev.artistuniverse.util.extension

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

fun String.uppercaseFirst(): String = this.replaceFirstChar { it.uppercase() }