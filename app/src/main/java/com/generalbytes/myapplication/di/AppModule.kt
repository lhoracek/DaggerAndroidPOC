package com.generalbytes.myapplication.di

import dagger.Module
import dagger.Provides


@Module
class AppModule {



//    @Singleton if given thing is singleton ..
//  @ApplicationScope  if given thing should be same for given application (in that case same as singleton)


    @Provides @First
    @ApplicationScope
    fun provideFirstNum(): Integer = Integer(Math.random().times(Integer.MAX_VALUE).toInt())

    @Provides @Second

    fun provideSecondNum(): Integer = Integer(Math.random().times(Integer.MAX_VALUE).toInt())
}