package com.generalbytes.myapplication.service

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.os.IBinder
import android.os.ResultReceiver
import dagger.android.DaggerService
import io.reactivex.Observable
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class DifferentProcessService : DaggerService() {
    @Inject lateinit var app: Application

    lateinit var receiver: ResultReceiver

    companion object{
        const val EXTRA_RECEIVER =  "DifferentProcessService.RECEIVER"
        const val EXTRA_DATA = "DifferentProcessService.DATA"
    }

    override fun onBind(p0: Intent?): IBinder? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        receiver = intent!!.getParcelableExtra(EXTRA_RECEIVER)
        Observable.interval(1, TimeUnit.SECONDS)
            .subscribe {
                Timber.d("Sending value $it app: ${app.toString()}")
                val bundle = Bundle()
                bundle.putInt(EXTRA_DATA, it.toInt())
                receiver.send(0, bundle)
            }
        return super.onStartCommand(intent, flags, startId)
    }
}