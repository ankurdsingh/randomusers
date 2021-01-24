package com.ankur.randomusers.view

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ankur.randomusers.R
import com.ankur.randomusers.databinding.ActivityHomeBinding
import com.ankur.randomusers.model.FormattedUserModel
import com.ankur.randomusers.utill.ViewModelProvideFactory
import com.ankur.randomusers.view.adapter.UsersListAdapter
import com.ankur.randomusers.viewmodel.RandomUserViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityHomeBinding
    @Inject
    lateinit var viewModelProvideFactory: ViewModelProvideFactory
    private lateinit var userDataViewModel: RandomUserViewModel
    private lateinit var userListAdapter: UsersListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home)
        initObject()
        observeViewModel()
    }

    private fun initObject() {
        userDataViewModel = ViewModelProvider(this, viewModelProvideFactory)
            .get(RandomUserViewModel::class.java)
        userListAdapter = UsersListAdapter(mutableListOf(),this)
        binding.rvUsersList.adapter = userListAdapter
        userDataViewModel.getUserProfile()
    }

    private fun observeViewModel() {
        userDataViewModel.profileData.observe(this, Observer {userProfiles->
            userProfiles?.let {
              userListAdapter.updateDataList(userProfiles)
            }
        })
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.ivAccept,R.id.tvAccept->{
                val position = v.tag as Int
                val userProfile = userListAdapter.mDataList?.get(position) as FormattedUserModel
                userProfile.isAccepted = true
                userDataViewModel.updateUserAction(userProfile)
                userListAdapter.notifyItemChanged(position)
            }
            R.id.ivDecline,R.id.tvDecline->{
                val position = v.tag as Int
                val userProfile = userListAdapter.mDataList?.get(position) as FormattedUserModel
                userProfile.isDeclined = true
                userDataViewModel.updateUserAction(userProfile)
                userListAdapter.notifyItemChanged(position)
            }
        }
    }

}