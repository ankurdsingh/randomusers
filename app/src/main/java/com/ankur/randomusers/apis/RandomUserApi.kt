package com.ankur.randomusers.apis

import com.ankur.randomusers.model.RandomUserResultModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface RandomUserApi {
    @GET("api/")
    fun fetchUsersProfile(@Query("results") results : Int):Call<RandomUserResultModel>
}