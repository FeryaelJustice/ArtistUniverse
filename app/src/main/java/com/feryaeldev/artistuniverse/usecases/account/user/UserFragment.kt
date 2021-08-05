package com.feryaeldev.artistuniverse.usecases.account.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.feryaeldev.artistuniverse.R
class UserFragment : Fragment() {

    private var listener: UserFragmentListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = UserFragment()
    }

    // Public

    fun setListener(listener: UserFragmentListener) {
        this.listener = listener
    }
}