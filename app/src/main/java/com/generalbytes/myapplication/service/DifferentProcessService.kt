package com.generalbytes.myapplication.service

import android.app.Application
import android.content.Intent
import android.os.IBinder
import com.generalbytes.myapplication.vm.ProcessServiceViewModel
import dagger.android.DaggerService
import io.reactivex.Observable
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class DifferentProcessService : DaggerService() {
    @Inject lateinit var serviceViewModel: ProcessServiceViewModel
    @Inject lateinit var app: Application

    override fun onBind(p0: Intent?): IBinder? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Observable.interval(1, TimeUnit.SECONDS)
            .subscribe {
                Timber.d("Sending value $it app: ${app.toString()}")
                serviceViewModel.subject.onNext((1000+it).toString())
            }
        return super.onStartCommand(intent, flags, startId)
    }
}