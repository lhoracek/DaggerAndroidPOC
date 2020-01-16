package cz.lhoracek.myapplication.core.di

import android.app.Application
import cz.lhoracek.myapplication.DependencyInjectionApplication
import dagger.android.AndroidInjector


open class BaseComponentFactory : IComponentFactory {
    override fun buildComponent(app: Application): AndroidInjector<DependencyInjectionApplication> =
        DaggerApplicationComponent
            .builder()
            .application(app)
            .build()
}

interface IComponentFactory {
    fun buildComponent(app: Application): AndroidInjector<DependencyInjectionApplication>
}