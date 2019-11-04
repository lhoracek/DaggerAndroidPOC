package com.generalbytes.myapplication.di

import com.generalbytes.myapplication.activity.FirstActivity
import com.generalbytes.myapplication.activity.SecondActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Scope

@Scope
@Retention
annotation class ActivityScope

@Module
abstract class ActivitiesModule {
    @ContributesAndroidInjector() @ActivityScope
    internal abstract fun contributeYourAndroidInjector(): FirstActivity

    @ContributesAndroidInjector() @ActivityScope
    internal abstract fun contributeSecondAndroidInjector(): SecondActivity
}