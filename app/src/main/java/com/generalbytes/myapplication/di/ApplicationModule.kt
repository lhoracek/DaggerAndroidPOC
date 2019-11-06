package com.generalbytes.myapplication.di

import com.generalbytes.myapplication.model.ApiDependency
import com.generalbytes.myapplication.model.SystemWideAPI
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Module(includes = [AndroidInjectionModule::class])
class ApplicationModule {

    @Provides
    @Singleton
    fun provideService(dependency: ApiDependency):SystemWideAPI = SystemWideAPI(dependency)

}