package com.generalbytes.myapplication.service

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.os.ResultReceiver
import com.generalbytes.myapplication.vm.ProcessServiceViewModel
import io.reactivex.Observable
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton


class DifferentProcessService : BaseService() {
    @Inject lateinit var app: Application

    @Singleton
    class DifferentProcessServiceManager @Inject constructor(): BaseReceiverServiceManager<ProcessServiceViewModel>(DifferentProcessService::class.java)  {
        override fun handleResult(resultCode: Int, resultData: Bundle?) {
            viewModel.subject.onNext(resultData?.getString(EXTRA_DATA) ?: "")
        }

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // TODO if we kill the app, intent redelivery does not work correctly, receiver is null
        val receiver = intent!!.getParcelableExtra<ResultReceiver>(BaseReceiverServiceManager.EXTRA_RECEIVER)
        disposable.add(Observable.interval(1, TimeUnit.SECONDS)
            .subscribe {
                val bundle = Bundle()
                bundle.putInt(BaseReceiverServiceManager.EXTRA_DATA, it.toInt())
                receiver.send(0, bundle)
            })
        return super.onStartCommand(intent, flags, startId)
    }
}