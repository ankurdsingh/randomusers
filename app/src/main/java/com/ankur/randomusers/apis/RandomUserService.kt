package com.ankur.randomusers.apis

import com.ankur.randomusers.model.FormattedUserModel
import com.ankur.randomusers.model.FormattedUserProfileDataModelAdapter
import com.ankur.randomusers.model.RandomUserResultModel
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class RandomUserService{
    private val baseURL = "https://randomuser.me/"

    var moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val api = Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
        .create(RandomUserApi::class.java)

    fun fetchProfile():Call<RandomUserResultModel>{
//        val map  = HashMap<String, String>()
//        map["results"] = 10.toString()
        return api.fetchUsersProfile(10)
    }
}