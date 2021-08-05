package com.feryaeldev.artistuniverse.model.session

import android.content.Context
import com.feryaeldev.artistuniverse.model.domain.User
import com.feryaeldev.artistuniverse.provider.preferences.PreferencesKey
import com.feryaeldev.artistuniverse.provider.preferences.PreferencesProvider

class Session {

    companion object {
        val instance = Session()
    }

    // Properties

    private var user: User? = null

    fun configure(context: Context, completion: () -> Unit) {
        PreferencesProvider.string(context, PreferencesKey.AUTH_USER)?.let {
            user = User.fromJson(it)
        }

        defaultUser(context, completion)
    }

    private fun save(context: Context, user: User, completion: () -> Unit) {
        PreferencesProvider.set(context, PreferencesKey.AUTH_USER, User.toJson(user)).apply {
            completion()
        }
    }

    private fun defaultUser(context: Context, completion: () -> Unit) {

        if (user == null) {

            // Usuario de sesión por defecto mientras no se autentica
            user = User()

            save(context, user!!,completion)
        }
    }

}