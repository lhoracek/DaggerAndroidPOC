package com.generalbytes.myapplication.di

import android.app.Application
import com.generalbytes.myapplication.DependencyInjectionApplication
import com.generalbytes.myapplication.di.modules.ActivityBindingModule
import com.generalbytes.myapplication.di.modules.ApplicationModule
import com.generalbytes.myapplication.di.modules.ServiceBindingModule
import com.generalbytes.myapplication.di.modules.ServiceManagerModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ApplicationModule::class,
        ActivityBindingModule::class,
        ServiceBindingModule::class,
        ServiceManagerModule::class
    ]
)
abstract class ApplicationComponent : AndroidInjector<DependencyInjectionApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AndroidInjector<DependencyInjectionApplication>
    }
}