package com.ankur.randomusers.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ankur.randomusers.model.FormattedUserModel

@Database(entities = [FormattedUserModel::class],version = 1)
abstract class UsersDB: RoomDatabase() {

    abstract fun userInfoDao() : UsersDao
}
