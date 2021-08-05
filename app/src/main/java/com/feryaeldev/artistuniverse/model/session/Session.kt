package com.feryaeldev.artistuniverse.model.session

import android.content.Context
import com.feryaeldev.artistuniverse.model.domain.User
import com.feryaeldev.artistuniverse.provider.preferences.PreferencesKey
import com.feryaeldev.artistuniverse.provider.preferences.PreferencesProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Session {

    companion object {
        val instance = Session()
    }

    // Properties

    private var user: User? = null
    private var firebaseAuthUid: String? = null

    fun configure(context: Context) {
        PreferencesProvider.string(context, PreferencesKey.AUTH_USER)?.let {
            user = User.fromJson(it)
        }
        firebaseAuthUid = PreferencesProvider.string(context, PreferencesKey.FIREBASE_AUTH_UID)

        defaultUser(context)
    }

    private fun save(context: Context, user: User) {
        PreferencesProvider.set(context, PreferencesKey.AUTH_USER, User.toJson(user))
    }

    private fun defaultUser(context: Context) {

        if (user == null) {

            // Usuario de sesión por defecto mientras no se autentica
            user = User()

            save(context, user!!)
        }
    }

    // Log out and clear all
    private fun clear(context: Context) {
        user = null
        firebaseAuthUid = null
        PreferencesProvider.clear(context)
        defaultUser(context)

        // Firebase Auth
        Firebase.auth.signOut()
        firebaseAuth(context)
    }


    private fun firebaseAuth(context: Context, completion: (() -> Unit)? = null) {
        if (firebaseAuthUid == null) {
            FirebaseAuth.getInstance().signInAnonymously().addOnSuccessListener { authResult ->
                authResult.user?.uid?.let { uid ->
                    PreferencesProvider.set(context, PreferencesKey.FIREBASE_AUTH_UID, uid)
                }
                completion?.invoke()
            }.addOnFailureListener {
                completion?.invoke()
            }
        } else {
            completion?.invoke()
        }
    }

}