package cz.lhoracek.myapplication.core.di.modules

import cz.lhoracek.myapplication.core.service.IStickyServiceManager
import cz.lhoracek.myapplication.core.service.StickyService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class ServiceManagerModule {

    @Provides
    @Singleton
    fun provideService(man: StickyService.StickyServiceManager):IStickyServiceManager = man

}