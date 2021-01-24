package com.ankur.randomusers.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RandomUserResultModel(val results : List<RandomUserProfileModel>) {
}