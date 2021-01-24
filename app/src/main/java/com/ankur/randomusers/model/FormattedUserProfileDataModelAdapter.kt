package com.ankur.randomusers.model

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.lang.StringBuilder

class FormattedUserProfileDataModelAdapter {
    @FromJson
    fun fromJson(userProfileModel: RandomUserProfileModel): FormattedUserModel{

        val nameBuilder = StringBuffer()
        nameBuilder.append(userProfileModel.name.first)
        nameBuilder.append(" ")
        nameBuilder.append(userProfileModel.name.last?:"")
        val name = nameBuilder.toString()

        val locationBuilder = StringBuilder();
        locationBuilder.append(userProfileModel.location.city)
        locationBuilder.append(", ")
        locationBuilder.append(userProfileModel.location.state)
        locationBuilder.append(", ")
        locationBuilder.append(userProfileModel.location.country)

        return FormattedUserModel(userProfileModel.email,name,userProfileModel.dob.age,userProfileModel.gender,locationBuilder.toString(),userProfileModel.picture.medium)
    }

    @ToJson
    fun toJson(formattedUserModel: FormattedUserModel):String{
        return formattedUserModel.toString()
    }
}