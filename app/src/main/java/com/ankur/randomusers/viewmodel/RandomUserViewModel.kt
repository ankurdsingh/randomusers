package com.ankur.randomusers.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ankur.randomusers.model.FormattedUserModel
import com.ankur.randomusers.model.RandomUserProfileModel
import com.ankur.randomusers.repo.RandomUserRepository
import javax.inject.Inject

class RandomUserViewModel @Inject constructor(val randomUserRepository: RandomUserRepository):ViewModel() {
    val profileData : LiveData<List<FormattedUserModel>>
    get() = randomUserRepository.profileData
    fun getUserProfile(){
        randomUserRepository.getProfiles()
    }

    fun updateUserAction(formattedUserModel: FormattedUserModel){
        randomUserRepository.updateUserAction(formattedUserModel)
    }
}