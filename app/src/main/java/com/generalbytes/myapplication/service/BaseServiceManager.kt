package com.generalbytes.myapplication.service

import android.app.Application
import android.app.Service
import android.content.Intent
import com.generalbytes.myapplication.vm.service.BaseServiceViewModel


abstract class BaseServiceManager<T : BaseServiceViewModel> (
    val app: Application,
    val viewModel: T,
    val serviceClass: Class<out Service>
) {
    companion object {
        const val START = 1
        const val STOP = 2
        const val DATA = 3
    }

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