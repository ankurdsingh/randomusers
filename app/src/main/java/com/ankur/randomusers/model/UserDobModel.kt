package com.ankur.randomusers.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserDobModel(val date : String,
                        val age: Int)
