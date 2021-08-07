package com.feryaeldev.artistuniverse.usecases.account.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.feryaeldev.artistuniverse.R
import com.mouredev.twitimer.usecases.common.views.userheader.UserHeaderFragment

class UserFragment : Fragment() {

    companion object {
        fun newInstance() = UserFragment()
    }

    // Properties

    private lateinit var viewModel: UserViewModel
    private var listener: UserFragmentListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // View Model
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        // Arguments
        arguments?.let { arguments ->
            UserRouter.user(arguments)?.let { user ->
                viewModel.setUser(user)
            }
        }

        if (listener != null || viewModel.getUser() != null) {
            setup()
        }
    }

    // Public

    fun setListener(listener: UserFragmentListener) {
        this.listener = listener
    }

    // Private
    private fun setup() {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        viewModel.getUser()?.let { user ->
            transaction?.replace(R.id.frameLayoutUserHeader, UserHeaderFragment.fragment(user))
        }
    }
}