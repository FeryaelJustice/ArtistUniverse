package com.feryaeldev.artistuniverse.provider.preferences

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

enum class PreferencesKey(val value: String) {
    AUTH_USER("authUser"),
    FIREBASE_AUTH_UID("firebaseAuthUid"),
    ONBOARDING("onboarding")
}

object PreferencesProvider {

    fun set(context: Context, key: PreferencesKey, value: String) {
        val editor = prefs(context).edit()
        editor.putString(key.value, value).apply()
    }

    fun string(context: Context, key: PreferencesKey): String? {
        return prefs(context).getString(key.value, null)
    }

    fun set(context: Context, key: PreferencesKey, value: Boolean) {
        val editor = prefs(context).edit()
        editor.putBoolean(key.value, value).apply()
    }

    fun boolean(context: Context, key: PreferencesKey): Boolean? {
        return prefs(context).getBoolean(key.value, false)
    }

    fun remove(context: Context, key: PreferencesKey) {
        val editor = prefs(context).edit()
        editor.remove(key.value).apply()
    }

    // Elimina las SharedPreferences del dominio app
    fun clear(context: Context) {
        val editor = prefs(context).edit()
        editor.clear().apply()
    }

    // Private

    private fun prefs(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

}