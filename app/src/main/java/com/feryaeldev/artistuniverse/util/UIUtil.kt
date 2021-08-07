package com.feryaeldev.artistuniverse.util

import android.content.Context
import android.net.Uri
import android.widget.ImageView
import android.widget.Toast
import com.feryaeldev.artistuniverse.R
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

object UIUtil {

    // Toast
    fun showToast(context: Context, message: String, duration: Int) {
        Toast.makeText(context, message, duration).show()
    }

    // Avatar
    fun loadAvatar(context: Context?, url: String?, user: String?, imageView: ImageView) {
        url?.let {
            Picasso.get().load(Uri.parse(url)).transform(CropCircleTransformation())
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(imageView)
        }
        context?.let {
            imageView.setOnLongClickListener {
                showToast(context, "Little easter egg!", Toast.LENGTH_SHORT)
                true
            }
        }
    }
}