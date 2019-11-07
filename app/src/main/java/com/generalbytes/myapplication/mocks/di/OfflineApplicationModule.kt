package com.generalbytes.myapplication.mocks.di

import com.generalbytes.myapplication.mocks.model.OfflineAPI
import com.generalbytes.myapplication.model.ApiInterface
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module()
open class OfflineApplicationModule {

    @Provides
    @Singleton
    fun provideService():ApiInterface = OfflineAPI()

}