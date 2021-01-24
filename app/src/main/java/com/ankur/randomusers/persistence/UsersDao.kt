package com.ankur.randomusers.persistence

import androidx.room.*
import com.ankur.randomusers.model.FormattedUserModel
import com.ankur.randomusers.model.RandomUserProfileModel

@Dao
interface UsersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(userProfileModel: List<FormattedUserModel>): List<Long>

    @Query("SELECT * From formattedusermodel")
    suspend fun getAllUsers(): List<FormattedUserModel>

    @Query("DELETE FROM formattedusermodel")
    suspend fun deleteAllUsers()

    @Update
    suspend fun updateUserInfo(userModel: FormattedUserModel)
}
