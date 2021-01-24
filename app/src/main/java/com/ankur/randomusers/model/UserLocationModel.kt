package com.ankur.randomusers.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserLocationModel(val city: String,
                             val state: String,
                             val country: String
)
