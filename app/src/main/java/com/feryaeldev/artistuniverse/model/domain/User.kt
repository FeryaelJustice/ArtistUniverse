package com.feryaeldev.artistuniverse.model.domain

import com.feryaeldev.artistuniverse.util.Constants
import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName

data class Users(val data: List<User>? = null) {

// Gson

    companion object {

        fun toJson(users: Users): String {
            return GsonBuilder().setDateFormat(Constants.JSON_DATE_FORMAT).create().toJson(users)
        }

        fun fromJson(json: String): Users {
            return GsonBuilder().setDateFormat(Constants.JSON_DATE_FORMAT).create()
                .fromJson(json, Users::class.java)
        }

    }
}

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
    @SerializedName("accounttype")
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
