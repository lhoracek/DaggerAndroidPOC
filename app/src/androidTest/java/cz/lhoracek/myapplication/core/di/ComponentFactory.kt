package cz.lhoracek.myapplication.core.di

import android.app.Application
import cz.lhoracek.myapplication.core.mocks.di.DaggerEmulatorOfflineApplicationComponent


class ComponentFactory : IComponentFactory {
    override fun buildComponent(app: Application) = DaggerEmulatorOfflineApplicationComponent
        .builder()
        .application(app)
        .build()
}