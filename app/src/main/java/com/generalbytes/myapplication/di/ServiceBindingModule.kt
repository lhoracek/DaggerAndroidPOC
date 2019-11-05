package com.generalbytes.myapplication.di

import com.generalbytes.myapplication.service.StickyService
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Scope

@Scope
@Retention
annotation class ServiceScope

@Module
abstract class ServiceBindingModule {
    @ContributesAndroidInjector
    @ServiceScope
    abstract fun stickyService(): StickyService


}