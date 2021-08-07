package com.feryaeldev.artistuniverse.usecases.account.user

import android.content.Context
import androidx.lifecycle.ViewModel
import com.feryaeldev.artistuniverse.model.domain.User
import com.feryaeldev.artistuniverse.model.session.Session

class UserViewModel: ViewModel() {

    // Properties

    private var user: User? = null // Read only user
    val readOnly get() = user != null

    // Public

    fun setUser(user: User) {
        this.user = user
    }

    fun getUser(): User? {
        return user ?: Session.instance.user
    }

    fun close(context: Context, listener: UserFragmentListener?) {

        Session.instance.clear(context) {
            listener?.onClose()
        }
    }
}