package com.generalbytes.myapplication.mocks.di

import android.app.Application
import com.generalbytes.myapplication.DependencyInjectionApplication
import com.generalbytes.myapplication.di.modules.ActivityBindingModule
import com.generalbytes.myapplication.di.modules.ServiceBindingModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        OfflineApplicationModule::class,
        ActivityBindingModule::class,
        ServiceBindingModule::class,
        EmulatorServiceBindingModule::class,
        EmulatorServiceManagerModule::class
    ]
)
abstract class EmulatorOfflineApplicationComponent : AndroidInjector<DependencyInjectionApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AndroidInjector<DependencyInjectionApplication>
    }
}