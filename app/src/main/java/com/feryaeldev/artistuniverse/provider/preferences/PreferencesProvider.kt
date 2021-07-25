package com.feryaeldev.artistuniverse.provider.preferences

import android.content.Context

enum class PreferencesKey(val value: String) {
    AUTH_USER("authUser")
}

object PreferencesProvider {

    fun set(context: Context, key: PreferencesKey, value: String) {
        /*val editor = prefs(context).edit()
        editor.putString(key.value, value).apply()*/
    }

}