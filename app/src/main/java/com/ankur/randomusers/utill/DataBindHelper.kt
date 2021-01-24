package com.ankur.randomusers.utill

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.ankur.randomusers.R
import com.ankur.randomusers.model.FormattedUserModel
import com.ankur.randomusers.model.RandomUserProfileModel
import com.ankur.randomusers.model.UserLocationModel
import com.ankur.randomusers.model.UserNameModel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.lang.StringBuilder


@BindingAdapter("android:primaryInfo")
fun setPrimaryInfo(textView: TextView, userModel: FormattedUserModel){
    val info = StringBuilder();
    info.append(userModel.age)
    info.append(" Yr, ")
    info.append(userModel.gender)
    textView.text = info.toString()
}


@BindingAdapter("android:profileMessage")
fun setProfileMessage(textView: TextView, userModel: FormattedUserModel){
    when {
        userModel.isAccepted -> {
            textView.visibility = View.VISIBLE
            textView.setTextColor(Color.GREEN)
            textView.text = textView.context.getString(R.string.profile_accepted)
        }
        userModel.isDeclined -> {
            textView.visibility = View.VISIBLE
            textView.setTextColor(Color.RED)
            textView.text = textView.context.getString(R.string.profile_declined)
        }
        else -> {
            textView.visibility = View.GONE
        }
    }
}

@BindingAdapter("android:loadImage")
fun loadImageSrc(imageView: ImageView, url: String?){
    val options = RequestOptions()
        .placeholder(R.mipmap.ic_launcher_round)
        .error(R.mipmap.ic_launcher_round)
    url?.let {
        Glide.with(imageView.context)
            .setDefaultRequestOptions(options)
            .load(it)
            .into(imageView)
    }
}

@BindingAdapter("android:loadImageCircle")
fun loadImageCircleSrc(imageView: ImageView, url: String?){
    val options = RequestOptions()
        .placeholder(R.mipmap.ic_launcher_round)
        .circleCrop()
        .error(R.mipmap.ic_launcher_round)
    url?.let {
        Glide.with(imageView.context)
            .setDefaultRequestOptions(options)
            .load(it)
            .into(imageView)
    }
}