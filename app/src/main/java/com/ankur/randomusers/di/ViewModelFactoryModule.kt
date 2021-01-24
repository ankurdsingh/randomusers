package com.ankur.randomusers.di

import androidx.lifecycle.ViewModelProvider
import com.ankur.randomusers.utill.ViewModelProvideFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule{

    @Binds
    abstract fun bindViewModelFactory(viewModelProvideFactory: ViewModelProvideFactory): ViewModelProvider.Factory
}