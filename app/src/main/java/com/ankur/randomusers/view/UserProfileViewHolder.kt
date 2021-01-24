package com.ankur.randomusers.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ankur.randomusers.databinding.LayoutUserProfileCardBinding

class UserProfileViewHolder(var view : LayoutUserProfileCardBinding,private val clickListener: View.OnClickListener):RecyclerView.ViewHolder(view.root) {

    init {
        view.ivAccept.setOnClickListener(clickListener)
        view.tvAccept.setOnClickListener(clickListener)
        view.ivDecline.setOnClickListener(clickListener)
        view.tvDecline.setOnClickListener(clickListener)
    }

}