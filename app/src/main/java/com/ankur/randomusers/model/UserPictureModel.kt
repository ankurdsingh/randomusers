package com.ankur.randomusers.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserPictureModel(val thumbnail: String,
                            val medium: String
)
