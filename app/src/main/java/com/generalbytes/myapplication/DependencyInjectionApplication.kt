package com.generalbytes.myapplication

import android.app.Application
import android.content.Intent
import com.generalbytes.myapplication.di.DaggerAppComponent
import com.generalbytes.myapplication.service.DifferentProcessService
import com.generalbytes.myapplication.service.StickyService
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
        DaggerAppComponent
            .builder()
            .application(this)
            .build()
            .inject(this)

        startService(Intent(this, StickyService::class.java))
        startService(Intent(this, DifferentProcessService::class.java))
    }

    override fun androidInjector() = dispatchingAndroidInjector
}