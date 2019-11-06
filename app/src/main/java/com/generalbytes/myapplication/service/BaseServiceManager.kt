package com.generalbytes.myapplication.service

import android.app.Application
import android.app.Service
import android.content.Intent
import com.generalbytes.myapplication.vm.service.BaseServiceViewModel
import javax.inject.Inject


abstract class BaseServiceManager<T : BaseServiceViewModel>(val serviceClass: Class<out Service>) {
    @Inject protected lateinit var viewModel: T

    companion object {
        const val START = 1
        const val STOP = 2
        const val DATA = 3
    }

    @Inject
    protected lateinit var app: Application

    protected open fun createIntent(): Intent {
        return Intent(app, serviceClass)
    }

    open fun start() {
        app.startService(createIntent())
    }

    open fun stop() {
        app.stopService(createIntent())
    }
}