package com.feryaeldev.artistuniverse.model.domain

import com.feryaeldev.artistuniverse.provider.services.firebase.DatabaseField
import com.feryaeldev.artistuniverse.util.Constants
import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("logged")
    val logged: Boolean? = null,
    @SerializedName("username")
    var userName: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("surnames")
    var surnames: String? = null,
    @SerializedName("accountType")
    var accountType: AccountType? = null,
    @SerializedName("bio")
    var bio: String? = null,
    @SerializedName("email")
    var email: String? = null,
    @SerializedName("age")
    var age: Int? = null,
    @SerializedName("country")
    var country: String? = null,
    @SerializedName("profile_image_url")
    var profileImageUrl: String? = null
) {

    // Optional
    @SerializedName("followedArtists")
    var followedArtists: MutableList<String>? = null

    fun toJSON(): Map<String, Any> {

        return mutableMapOf<String, Any>(
            DatabaseField.ID.key to (id ?: ""),
            DatabaseField.LOGGED.key to (logged ?: ""),
            DatabaseField.USERNAME.key to (userName ?: ""),
            DatabaseField.NAME.key to (name ?: ""),
            DatabaseField.SURNAMES.key to (surnames ?: ""),
            DatabaseField.ACCOUNT_TYPE.key to (accountType?.type ?: ""),
            DatabaseField.BIO.key to (bio ?: ""),
            DatabaseField.EMAIL.key to (email ?: ""),
            DatabaseField.AGE.key to (age ?: ""),
            DatabaseField.COUNTRY.key to (age ?: ""),
            DatabaseField.PROFILE_IMAGE_URL.key to (profileImageUrl ?: ""),
        )
    }


    // Gson

    companion object {

        fun toJson(user: User): String {
            return GsonBuilder().setDateFormat(Constants.JSON_DATE_FORMAT).create().toJson(user)
        }

        fun fromJson(json: String): User {
            return GsonBuilder().setDateFormat(Constants.JSON_DATE_FORMAT).create()
                .fromJson(json, User::class.java)
        }

    }
}

enum class AccountType(val type: String) {

    @SerializedName("user")
    USER("user"),

    @SerializedName("artist")
    ARTIST("artist"),

    @SerializedName("")
    NONE("");

    companion object {

        fun valueFrom(type: String): AccountType {
            return values().find { it.type == type } ?: NONE
        }
    }

}
