package com.mouredev.twitimer.usecases.common.views.userheader

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.feryaeldev.artistuniverse.R
import com.feryaeldev.artistuniverse.model.domain.User
import com.feryaeldev.artistuniverse.util.Size

class UserHeaderFragment : Fragment() {

    companion object {

        private const val USER = "USER"
        private const val SMALL = "SMALL"

        @JvmStatic
        fun fragment(user: User? = null, small: Boolean = false) =
            UserHeaderFragment().apply {
                arguments = Bundle().apply {
                    user?.let { user ->
                        putString(USER, User.toJson(user))
                    }
                    putBoolean(SMALL, small)
                }
            }
    }

    // Properties

    private var user: User? = null
    private var small = false

    // Initialization

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user_header, container, false)

        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(
            R.id.frameLayoutUserAvatar,
            UserAvatarFragment.fragment(
                user?.profileImageUrl ?: "",
                (user?.logged ?: "") as String,
                if (small) Size.VERY_BIG else Size.GIGANT
            )
        )
        transaction?.disallowAddToBackStack()
        transaction?.commit()

        val textViewUser = view.findViewById<TextView>(R.id.textViewUser)
        val textViewUserName = view.findViewById<TextView>(R.id.textViewUsername)

        textViewUser.text = user?.name ?: ""
        textViewUserName.text = "@${user?.logged ?: ""}"

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Arguments
        arguments?.let { arguments ->
            arguments.getString(USER)?.let { userJSON ->
                user = User.fromJson(userJSON)
            }
            small = arguments.getBoolean(SMALL)

            // Setup
            setup()
            data()
        }
    }

    // Private

    private fun setup() {
    }

    @SuppressLint("SetTextI18n")
    private fun data() {

    }

}