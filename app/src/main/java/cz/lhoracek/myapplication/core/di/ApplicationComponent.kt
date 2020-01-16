package cz.lhoracek.myapplication.core.di

import android.app.Application
import cz.lhoracek.myapplication.DependencyInjectionApplication
import cz.lhoracek.myapplication.core.di.modules.ActivityBindingModule
import cz.lhoracek.myapplication.core.di.modules.ApplicationModule
import cz.lhoracek.myapplication.core.di.modules.ServiceBindingModule
import cz.lhoracek.myapplication.core.di.modules.ServiceManagerModule
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