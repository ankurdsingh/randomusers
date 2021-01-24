package com.ankur.randomusers.di

import android.app.Application
import androidx.room.Room
import com.ankur.randomusers.persistence.UsersDB
import com.ankur.randomusers.persistence.UsersDao
import com.ankur.randomusers.repo.RandomUserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Singleton
    @Provides
    fun providesAppDatabase(app: Application):UsersDB{
        return Room.databaseBuilder(app,UsersDB::class.java,"users_database").build()
    }

    @Singleton
    @Provides
    fun providesNoteDao(db: UsersDB): UsersDao {
        return db.userInfoDao()
    }

    @Provides
    fun providesRepository(usersDao: UsersDao):RandomUserRepository{
        return RandomUserRepository(usersDao)
    }
}