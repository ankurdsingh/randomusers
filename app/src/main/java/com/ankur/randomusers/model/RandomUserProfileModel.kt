package com.ankur.randomusers.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RandomUserProfileModel(val gender: String,
                                  val name: UserNameModel,
                                  val location: UserLocationModel,
                                  val dob: UserDobModel,
                                  val email: String,
                                  val picture: UserPictureModel
)