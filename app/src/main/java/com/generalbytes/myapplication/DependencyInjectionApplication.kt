package com.generalbytes.myapplication

import android.app.Application
import com.generalbytes.myapplication.di.ComponentFactory
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import timber.log.Timber
import javax.inject.Inject


class DependencyInjectionApplication : Application(), HasAndroidInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        ComponentFactory().buildComponent(this).inject(this)
    }

    override fun androidInjector() = dispatchingAndroidInjector
}