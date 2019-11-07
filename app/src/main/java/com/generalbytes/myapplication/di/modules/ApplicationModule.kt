package com.generalbytes.myapplication.di.modules

import com.generalbytes.myapplication.model.ApiDependency
import com.generalbytes.myapplication.model.ApiInterface
import com.generalbytes.myapplication.model.SystemWideAPI
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class ApplicationModule {

    @Provides
    @Singleton
    fun provideService(dependency: ApiDependency):ApiInterface = SystemWideAPI(dependency)

}