package com.ankur.randomusers

import com.ankur.randomusers.di.DaggerRandomUserComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class RandomUsers:DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerRandomUserComponent.
        builder().
        application(this).
        build()
    }
}