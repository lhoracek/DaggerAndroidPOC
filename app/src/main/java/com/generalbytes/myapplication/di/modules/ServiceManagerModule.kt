package com.generalbytes.myapplication.di.modules

import com.generalbytes.myapplication.service.IStickyServiceManager
import com.generalbytes.myapplication.service.StickyService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class ServiceManagerModule {

    @Provides
    @Singleton
    fun provideService(man: StickyService.StickyServiceManager):IStickyServiceManager = man

}