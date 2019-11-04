package com.generalbytes.myapplication.di

import com.generalbytes.myapplication.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivitiesModule {
    @ContributesAndroidInjector()
    abstract fun contributeActivityAndroidInjector(): MainActivity

}