package com.simgesengun.armutapplication.adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.databinding.BindingAdapter
import com.simgesengun.armutapplication.R
import com.squareup.picasso.Picasso

@BindingAdapter("android:image_resource")
fun setImageResource(imageView: ImageView, imageUrl: String?) {
    Picasso.get().load(imageUrl).into(imageView)
}
