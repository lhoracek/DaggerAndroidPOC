package cz.lhoracek.myapplication.core.di.modules

import cz.lhoracek.myapplication.core.model.ApiDependency
import cz.lhoracek.myapplication.core.model.ApiInterface
import cz.lhoracek.myapplication.core.model.SystemWideAPI
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class ApplicationModule {

    @Provides
    @Singleton
    fun provideService(dependency: ApiDependency):ApiInterface = SystemWideAPI(dependency)

}