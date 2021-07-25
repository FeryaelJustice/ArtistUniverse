package com.feryaeldev.artistuniverse.model.session

import com.feryaeldev.artistuniverse.model.domain.User

class Session {

    companion object {
        val instance = Session()
    }

    // Properties

    var user: User? = null
        private set

    private enum class LanguageType(val code: String) {
        ES("0")
    }

}