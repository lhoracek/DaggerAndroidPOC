package cz.lhoracek.myapplication.core.service

import android.app.Application
import android.app.Service
import android.content.Intent
import cz.lhoracek.myapplication.core.vm.service.BaseServiceViewModel


abstract class BaseServiceManager<T : BaseServiceViewModel> (
    val app: Application,
    val viewModel: T,
    val serviceClass: Class<out Service>
): IBaseServiceManager {
    companion object {
        const val START = 1
        const val STOP = 2
        const val DATA = 3
    }

    protected open fun createIntent(): Intent {

        return Intent(app, serviceClass)
    }

    override fun start() {
        app.startService(createIntent())
    }

    override fun stop() {
        app.stopService(createIntent())
    }
}


interface IBaseServiceManager{
    fun start()
    fun stop()
}