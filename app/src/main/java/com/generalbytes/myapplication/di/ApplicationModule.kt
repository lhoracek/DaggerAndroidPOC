package com.generalbytes.myapplication.di

import android.graphics.Color
import dagger.Module
import dagger.Provides
import java.util.*


@Module
class ApplicationModule {
    @Provides @First
    @ApplicationScope
    fun provideFirstNum(): Integer = numberFactory()

    @Provides @Second
    fun provideSecondNum(): Integer = numberFactory()


    var rnd = Random()
    private fun numberFactory(): Integer = Integer(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)))
}