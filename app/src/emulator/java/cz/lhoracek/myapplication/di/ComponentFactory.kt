package com.generalbytes.myapplication.di

import android.app.Application
import com.generalbytes.myapplication.mocks.di.DaggerEmulatorApplicationComponent


class ComponentFactory : IComponentFactory {
    override fun buildComponent(app: Application) = DaggerEmulatorApplicationComponent
        .builder()
        .application(app)
        .build()
}