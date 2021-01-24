package com.ankur.randomusers.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@Entity
@JsonClass(generateAdapter = true)
data class FormattedUserModel(
    @PrimaryKey val email: String,
    val name: String,
    val age: Int,
    val gender: String,
    val location: String,
    val imgUrl: String,
    var isAccepted: Boolean = false,
    var isDeclined: Boolean = false
)