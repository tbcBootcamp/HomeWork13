package com.example.homework13.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.homework13.R

class Glide {

    fun setImage(url: String, image: ImageView){
        Glide
            .with(image.context)
            .load(url)
            .centerCrop()
            .into(image)
    }
}