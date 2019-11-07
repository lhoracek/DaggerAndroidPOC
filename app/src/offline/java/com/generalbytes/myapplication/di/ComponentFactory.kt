package com.generalbytes.myapplication.di

import android.app.Application
import com.generalbytes.myapplication.mocks.di.DaggerOfflineApplicationComponent


class ComponentFactory: IComponentFactory{
    override fun buildComponent(app: Application) = DaggerOfflineApplicationComponent
        .builder()
        .application(app)
        .build()
}