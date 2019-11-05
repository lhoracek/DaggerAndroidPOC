package com.generalbytes.myapplication.service

import android.app.Service
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.ResultReceiver
import androidx.lifecycle.ViewModel
import javax.inject.Inject


abstract class BaseReceiverServiceManager<T : ViewModel>(val serviceClazz: Class<out Service>): BaseServiceManager<T>(serviceClazz){

    @Inject protected lateinit var viewModel: T

    companion object{
        const val EXTRA_RECEIVER =  "BaseReceiverServiceManager.RECEIVER"
        const val EXTRA_DATA = "BaseReceiverServiceManager.DATA"
    }

    private val receiver = object : ResultReceiver(Handler()) {
        override fun onReceiveResult(resultCode: Int, resultData: Bundle?) {
            super.onReceiveResult(resultCode, resultData)
            handleResult(resultCode, resultData)
        }
    }

    override fun createIntent(): Intent {
        val intent = super.createIntent()
        intent.putExtra(EXTRA_RECEIVER, receiver)
        return intent
    }

    abstract fun handleResult(resultCode: Int, resultData: Bundle?)
}