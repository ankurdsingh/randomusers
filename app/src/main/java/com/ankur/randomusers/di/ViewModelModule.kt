package com.ankur.randomusers.di

import androidx.lifecycle.ViewModel
import com.ankur.randomusers.viewmodel.RandomUserViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(RandomUserViewModel::class)
    abstract fun bindRandomPeopleViewModel(nearbyPlacesViewModel: RandomUserViewModel):ViewModel
}