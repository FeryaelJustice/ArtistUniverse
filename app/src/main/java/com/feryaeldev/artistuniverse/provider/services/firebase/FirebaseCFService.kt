package com.feryaeldev.artistuniverse.provider.services.firebase

import com.feryaeldev.artistuniverse.model.domain.User

enum class DatabaseField(val key: String) {

    // Schemes
    USERS("users"), ARTISTS("artists"),

    // User
    ID("id"), LOGIN("login"), DISPLAY_NAME("displayName"), PROFILE_IMAGE_URL("profileImageUrl"), OFFLINE_IMAGE_URL(
        "offlineImageUrl"
    )

}

object FirebaseCFService {

    // Properties

    /*
    private val usersRef = FirebaseFirestore.getInstance().getReference(DatabaseField.USERS.key)
    private val artistsRef = FirebaseFirestore.getInstance().getReference(DatabaseField.ARTISTS.key)
    */

    // Services

    fun save(user: User) {
        user.login.let { login ->
            if (login) {
                print("a")
            }
        }
    }
}