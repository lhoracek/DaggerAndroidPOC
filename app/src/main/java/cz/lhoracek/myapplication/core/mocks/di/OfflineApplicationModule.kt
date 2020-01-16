package cz.lhoracek.myapplication.core.mocks.di

import cz.lhoracek.myapplication.core.mocks.model.OfflineAPI
import cz.lhoracek.myapplication.core.model.ApiInterface
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module()
open class OfflineApplicationModule {

    @Provides
    @Singleton
    fun provideService():ApiInterface = OfflineAPI()

}