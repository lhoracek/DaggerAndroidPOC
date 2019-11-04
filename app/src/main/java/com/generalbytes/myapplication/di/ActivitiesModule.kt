package com.generalbytes.myapplication.di

import com.generalbytes.myapplication.activity.FirstActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivitiesModule {
    @ContributesAndroidInjector()
    abstract fun contributeActivityAndroidInjector(): FirstActivity

}