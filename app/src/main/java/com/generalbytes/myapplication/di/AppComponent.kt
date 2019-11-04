package com.generalbytes.myapplication.di

import android.app.Application
import com.generalbytes.myapplication.DiApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Qualifier
import javax.inject.Scope


@Scope
@Retention
annotation class ApplicationScope


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class First


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Second

@ApplicationScope
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivitiesModule::class]
)
interface AppComponent {


    @First fun getNumber(): Integer
    @Second fun getSecondNumber(): Integer

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(githubApp: DiApp)
}