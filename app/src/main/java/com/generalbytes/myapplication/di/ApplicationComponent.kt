package com.generalbytes.myapplication.di

import android.app.Application
import com.generalbytes.myapplication.DiApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        ActivityBindingModule::class,
        ServiceBindingModule::class
    ]
)
interface AppComponent : AndroidInjector<DiApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}