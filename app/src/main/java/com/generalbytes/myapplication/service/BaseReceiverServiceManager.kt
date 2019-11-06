package com.generalbytes.myapplication.service

import android.app.Application
import android.app.Service
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.ResultReceiver
import com.generalbytes.myapplication.vm.service.BaseServiceViewModel


abstract class BaseReceiverServiceManager<T : BaseServiceViewModel> (
    app: Application,
    viewModel: T,
    serClass: Class<out Service>
) : BaseServiceManager<T>(app, viewModel, serClass) {

    companion object {
        const val EXTRA_RECEIVER = "BaseReceiverServiceManager.RECEIVER"
        const val EXTRA_DATA = "BaseReceiverServiceManager.DATA"
    }

    private val receiver = object : ResultReceiver(Handler()) {
        override fun onReceiveResult(resultCode: Int, resultData: Bundle?) {
            when (resultCode) {
                START -> viewModel.running.set(true)
                STOP -> viewModel.running.set(false)
                DATA -> handleData(resultData)
                else -> super.onReceiveResult(resultCode, resultData)
            }
        }
    }

    override fun createIntent(): Intent {
        val intent = super.createIntent()
        intent.putExtra(EXTRA_RECEIVER, receiver)
        return intent
    }

    abstract fun handleData(resultData: Bundle?)
}