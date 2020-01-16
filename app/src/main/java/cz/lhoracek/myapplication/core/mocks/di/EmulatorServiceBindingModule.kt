package cz.lhoracek.myapplication.core.mocks.di

import cz.lhoracek.myapplication.core.mocks.service.EmulatorStickyService
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