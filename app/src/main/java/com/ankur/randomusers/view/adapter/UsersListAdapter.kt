package com.ankur.randomusers.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ankur.randomusers.R
import com.ankur.randomusers.databinding.LayoutUserProfileCardBinding
import com.ankur.randomusers.model.FormattedUserModel
import com.ankur.randomusers.view.UserProfileViewHolder

class UsersListAdapter(var mDataList : List<FormattedUserModel>?, private val clickListener: View.OnClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<LayoutUserProfileCardBinding>(inflater, R.layout.layout_user_profile_card,parent,false)
        return UserProfileViewHolder(binding,clickListener)
    }

    override fun getItemCount() = mDataList?.size?:0

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is UserProfileViewHolder){
            holder.view.user = mDataList?.get(position)
            holder.view.ivAccept.tag = position
            holder.view.tvAccept.tag = position
            holder.view.ivDecline.tag = position
            holder.view.tvDecline.tag = position
        }
    }

    fun updateDataList(mDataList : List<FormattedUserModel>){
        this.mDataList = mDataList
        notifyDataSetChanged()
    }
}