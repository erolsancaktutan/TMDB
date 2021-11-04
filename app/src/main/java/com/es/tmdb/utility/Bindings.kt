package com.es.tmdb.utility

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

object Bindings {
    @BindingAdapter("loadImage")
    @JvmStatic
    fun loadImage(iv: ImageView, url:String ){
        Glide.with(iv.context)
            .asBitmap()
            .load(url)
            .into(object : CustomTarget<Bitmap>() {
                override fun onLoadCleared(placeholder: Drawable?) {
                }

                override fun onResourceReady(
                    resource: Bitmap,
                    transition: Transition<in Bitmap>?,
                ) {
                    iv.setImageBitmap(resource)
                }
            })
    }
}