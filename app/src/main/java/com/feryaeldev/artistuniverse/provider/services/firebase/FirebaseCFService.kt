package com.feryaeldev.artistuniverse.provider.services.firebase

import com.feryaeldev.artistuniverse.model.domain.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

enum class DatabaseField(val key: String) {

    // Schemes
    USERS("users"), ARTISTS("artists"),

    // User
    ID("id"), LOGGED("logged"), USERNAME("username"), NAME("username"), SURNAMES("profileImageUrl"),
    ACCOUNT_TYPE("accountType"), BIO("bio"), EMAIL("email"), AGE("age"), COUNTRY("country"), PROFILE_IMAGE_URL(
        "profile_image_url"
    )

}

object FirebaseCFService {

    // Properties

    private val usersRef = Firebase.firestore.collection(DatabaseField.USERS.key)
    // private val artistsRef = Firebase.firestore.collection(DatabaseField.ARTISTS.key)

    // Services

    fun save(user: User) {
        user.logged.let { logged ->
            if (logged == true) {
                user.id?.let { id -> usersRef.document(id).set(user).addOnCompleteListener {

                } }
            }
        }
    }
}