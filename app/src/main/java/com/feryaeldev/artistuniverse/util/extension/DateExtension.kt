package com.feryaeldev.artistuniverse.util.extension

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

fun Date.toJSON(): String {
    val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZ", Locale.getDefault())
    return formatter.format(this)
}

fun Date.longFormat(): String {
    return DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.SHORT, Locale.getDefault()).format(this).uppercaseFirst()
}

fun Date.mediumFormat(): String {
    return DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT, Locale.getDefault()).format(this).uppercaseFirst()
}

fun Date.shortFormat(): String {
    return DateFormat.getTimeInstance(DateFormat.SHORT, Locale.getDefault()).format(this).format(this).uppercaseFirst()
}