package cz.lhoracek.myapplication

import android.app.Application
import cz.lhoracek.myapplication.core.di.ComponentFactory
import com.ivoberger.timbersentry.SentryTree
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import timber.log.Timber
import javax.inject.Inject


class DependencyInjectionApplication : Application(), HasAndroidInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
        else Timber.plant(SentryTree("https://a2cd8b46f5df4650a7481e717349eb42@sentry.io/1853733"))


        ComponentFactory().buildComponent(this).inject(this)
    }

    override fun androidInjector() = dispatchingAndroidInjector
}