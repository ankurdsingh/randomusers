package com.ankur.randomusers.di

import android.app.Application
import com.ankur.randomusers.RandomUsers
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class,
    AppModule::class,
    ActivityBuilderModule::class])
interface RandomUserComponent : AndroidInjector<RandomUsers> {
    //We have to instruct the component how to build itself. We do this with the @Component.Builder annotation.
    @Component.Builder
    interface Builder {
        fun build(): RandomUserComponent

        @BindsInstance
        fun application(application: Application):Builder

    }
}