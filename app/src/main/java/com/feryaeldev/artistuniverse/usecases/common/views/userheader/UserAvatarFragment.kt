package com.mouredev.twitimer.usecases.common.views.userheader

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.feryaeldev.artistuniverse.R
import com.feryaeldev.artistuniverse.util.Size
import com.feryaeldev.artistuniverse.util.UIUtil
import com.feryaeldev.artistuniverse.util.Util

class UserAvatarFragment : Fragment() {

    companion object {

        private const val URL = "URL"
        private const val USER = "USER"
        private const val SIZE = "SIZE"

        @JvmStatic
        fun fragment(url: String, user: String, size: Size) =
            UserAvatarFragment().apply {
                arguments = Bundle().apply {
                    putString(URL, url)
                    putString(USER, user)
                    putString(SIZE, size.name)
                }
            }
    }

    // Properties

    private var url: String? = null
    private var user: String? = null
    private var size = com.feryaeldev.artistuniverse.util.Size.GIGANT

    // Initialization

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.user_avatar_fragment, container, false)
        // Setup
        context?.let { context ->
            val dp = Util.dpToPixel(context, size.size).toInt()

            val avatar = view.findViewById<ImageView>(R.id.imageViewAvatar)
            avatar.layoutParams.width = dp
            avatar.layoutParams.height = dp

            UIUtil.loadAvatar(
                context,
                url,
                user,
                avatar
            )
        }
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Arguments
        arguments?.let { arguments ->
            url = arguments.getString(URL)
            user = arguments.getString(USER)
            arguments.getString(SIZE)?.let { sizeName ->
                size = Size.valueOf(sizeName)
            }

        }
    }

    // Private

}