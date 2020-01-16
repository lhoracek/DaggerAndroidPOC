package cz.lhoracek.myapplication.core.di.modules

import cz.lhoracek.myapplication.core.service.MessengerProcessService
import cz.lhoracek.myapplication.core.service.ResultReceiverProcessService
import cz.lhoracek.myapplication.core.service.StickyService
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Scope

@Scope
@Retention
annotation class ServiceScope

@Module
abstract class ServiceBindingModule {
    @ContributesAndroidInjector @ServiceScope
    abstract fun stickyService(): StickyService
    @ContributesAndroidInjector @ServiceScope
    abstract fun differentProcessService(): ResultReceiverProcessService
    @ContributesAndroidInjector @ServiceScope
    abstract fun messengerProcessService(): MessengerProcessService
}