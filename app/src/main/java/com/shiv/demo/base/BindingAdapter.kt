package com.shiv.demo.base

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("loadImage")
fun ImageView.loadImage(imageString: String?) {
    imageString?.let {
        Glide.with(context).load(imageString).into(this)
    }
}