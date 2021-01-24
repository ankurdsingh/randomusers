package com.ankur.randomusers.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.ankur.randomusers.apis.RandomUserService
import com.ankur.randomusers.model.FormattedUserModel
import com.ankur.randomusers.model.FormattedUserProfileDataModelAdapter
import com.ankur.randomusers.model.FormattedUserProfileResultModel
import com.ankur.randomusers.model.RandomUserResultModel
import com.ankur.randomusers.persistence.UsersDao
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import java.lang.reflect.Type
import javax.inject.Inject
import javax.security.auth.callback.Callback


class RandomUserRepository @Inject constructor(val usersDao: UsersDao){

    val profileData = MutableLiveData<List<FormattedUserModel>>()

    fun getProfiles(){
        val randomUserService = RandomUserService()
        val call = randomUserService.fetchProfile()
        Log.d("RandomUsers URL: ", call.request().url().toString())
        call.enqueue(object : Callback,
                retrofit2.Callback<RandomUserResultModel> {
            override fun onFailure(call: Call<RandomUserResultModel>, t: Throwable) {
                Log.d("RandomUsers error: ", t.toString())
                CoroutineScope(Dispatchers.IO).launch {
                      profileData.postValue(usersDao.getAllUsers())
                    }
            }

            override fun onResponse(
                    call: Call<RandomUserResultModel>,
                    response: Response<RandomUserResultModel>
            ) {
                Log.d("RandomUsers: isSuccess", response.isSuccessful.toString())
                Log.d("RandomUsers: ", response.raw().toString())
                Log.d("RandomUsers: Body ", response.body().toString())

                val profileResultResponseModel =  response.body() /*?: jsonAdapter.fromJson(getResponse())*/
                if(profileResultResponseModel!=null) {
                    val moshi = Moshi.Builder().build()
                    val jsonAdapter: JsonAdapter<RandomUserResultModel> = moshi.adapter(RandomUserResultModel::class.java)
                    val json = jsonAdapter.toJson(profileResultResponseModel)

                    val moshi2 = Moshi.Builder().add(FormattedUserProfileDataModelAdapter()).build()
                    val customJsonAdapter: JsonAdapter<FormattedUserProfileResultModel> = moshi2.adapter(FormattedUserProfileResultModel::class.java)
                    val formattedUserModelList: FormattedUserProfileResultModel? = customJsonAdapter.fromJson(json)
                    Log.d("RandomUsers:Format", formattedUserModelList.toString())
                    CoroutineScope(Dispatchers.IO).launch {
                        formattedUserModelList?.results?.let {
                            val res = usersDao.insertUsers(it)
                            if(res.isNotEmpty()){
                               profileData.postValue(usersDao.getAllUsers())
                            }
                        }
                    }
                    //profileData.postValue(formattedUserModelList?.results)
                }
            }
        })

    }

    fun updateUserAction(formattedUserModel: FormattedUserModel){
      CoroutineScope(Dispatchers.IO).launch {
          usersDao.updateUserInfo(formattedUserModel)
      }
    }
}