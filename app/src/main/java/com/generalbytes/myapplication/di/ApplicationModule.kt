package com.generalbytes.myapplication.di

import android.graphics.Color
import com.generalbytes.myapplication.model.First
import com.generalbytes.myapplication.model.Fourth
import com.generalbytes.myapplication.model.Second
import com.generalbytes.myapplication.model.Third
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import java.util.*
import javax.inject.Singleton

@Module(includes = [AndroidInjectionModule::class])
class ApplicationModule {

    @Provides
    fun provideFirstNum() = First(numberFactory())

    @Provides
    @Singleton
    fun provideSecondNum() = Second(numberFactory())

    @Provides
    fun provideThirdNum() = Third(numberFactory())

    @Provides
    fun provideFourthNum() = Fourth(numberFactory())

    companion object {
        var rnd = Random()
        fun numberFactory() = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }

}