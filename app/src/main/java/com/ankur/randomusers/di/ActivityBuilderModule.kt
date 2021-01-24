package com.ankur.randomusers.di

import com.ankur.randomusers.view.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

// declare all the activity here , dependency of activity are provided by this module
@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun contributeHomeActivity(): HomeActivity

}