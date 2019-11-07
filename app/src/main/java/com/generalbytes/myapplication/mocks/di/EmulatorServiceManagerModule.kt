package com.generalbytes.myapplication.mocks.di

import com.generalbytes.myapplication.mocks.service.EmulatorStickyService
import com.generalbytes.myapplication.service.IStickyServiceManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class EmulatorServiceManagerModule {

    @Provides
    @Singleton
    fun provideService(man: EmulatorStickyService.EmulatorStickyServiceManager):IStickyServiceManager = man

}