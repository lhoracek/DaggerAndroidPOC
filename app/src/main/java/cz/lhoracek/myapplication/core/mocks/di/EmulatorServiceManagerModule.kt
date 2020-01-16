package cz.lhoracek.myapplication.core.mocks.di

import cz.lhoracek.myapplication.core.mocks.service.EmulatorStickyService
import cz.lhoracek.myapplication.core.service.IStickyServiceManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class EmulatorServiceManagerModule {

    @Provides
    @Singleton
    fun provideService(man: EmulatorStickyService.EmulatorStickyServiceManager):IStickyServiceManager = man

}