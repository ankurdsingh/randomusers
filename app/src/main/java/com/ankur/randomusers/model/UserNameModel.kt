package com.ankur.randomusers.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserNameModel(val title: String?,
                         val first: String,
                         val last: String?)