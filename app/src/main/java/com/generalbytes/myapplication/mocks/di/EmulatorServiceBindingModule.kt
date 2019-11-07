package com.generalbytes.myapplication.mocks.di

import com.generalbytes.myapplication.mocks.service.EmulatorStickyService
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Scope

@Scope
@Retention
annotation class ServiceScope

@Module
abstract class EmulatorServiceBindingModule {
    @ContributesAndroidInjector @ServiceScope
    abstract fun stickyService(): EmulatorStickyService
}