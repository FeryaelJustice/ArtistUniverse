package com.feryaeldev.artistuniverse.util.extension

import android.widget.Button
import com.feryaeldev.artistuniverse.util.UIConstants

fun Button.enable(enable: Boolean, opacity: Boolean = false) {
    if (opacity) {
        alpha = if (enable) 1f else UIConstants.SHADOW_OPACITY
    }
    isEnabled = enable
}