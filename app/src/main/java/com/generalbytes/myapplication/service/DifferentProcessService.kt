package com.generalbytes.myapplication.service

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.os.ResultReceiver
import io.reactivex.Observable
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class DifferentProcessService : BaseService() {
    @Inject lateinit var app: Application

    companion object{
        const val EXTRA_RECEIVER =  "DifferentProcessService.RECEIVER"
        const val EXTRA_DATA = "DifferentProcessService.DATA"
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val receiver = intent!!.getParcelableExtra<ResultReceiver>(EXTRA_RECEIVER)
        disposable.add(Observable.interval(1, TimeUnit.SECONDS)
            .subscribe {
                val bundle = Bundle()
                bundle.putInt(EXTRA_DATA, it.toInt())
                receiver.send(0, bundle)
            })
        return super.onStartCommand(intent, flags, startId)
    }
}