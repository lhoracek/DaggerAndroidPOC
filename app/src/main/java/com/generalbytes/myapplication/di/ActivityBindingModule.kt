package com.generalbytes.myapplication.di

import androidx.appcompat.app.AppCompatActivity
import com.generalbytes.myapplication.activity.FirstActivity
import com.generalbytes.myapplication.activity.SecondActivity
import com.generalbytes.myapplication.model.Third
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Scope

@Scope
@Retention
annotation class ActivityScope

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector(modules = [ActivityScopeModule::class])
    @ActivityScope
    abstract fun firstActivity(): FirstActivity

    @ContributesAndroidInjector(modules = [ActivityScopeModule::class])
    @ActivityScope
    abstract fun secondActivity(): SecondActivity
}

@Module(includes = [FragmentBindingModule::class])
class ActivityScopeModule {

    @Provides
    @ActivityScope
    fun provideThirdNum() = Third(ApplicationModule.numberFactory())

    @Provides
    @ActivityScope
    fun provideActivity(activity: AppCompatActivity) = activity

    @Provides
    @ActivityScope
    fun provideFragmentManager(activity: AppCompatActivity) = activity.supportFragmentManager
}