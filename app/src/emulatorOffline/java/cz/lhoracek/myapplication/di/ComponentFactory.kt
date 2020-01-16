package com.generalbytes.myapplication.di

import android.app.Application
import com.generalbytes.myapplication.mocks.di.DaggerEmulatorOfflineApplicationComponent


class ComponentFactory : IComponentFactory {
    override fun buildComponent(app: Application) = DaggerEmulatorOfflineApplicationComponent
        .builder()
        .application(app)
        .build()
}