package com.generalbytes.myapplication.service

import android.app.Application
import android.content.Intent
import com.generalbytes.myapplication.vm.ServiceViewModel
import io.reactivex.Observable
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class StickyService : BaseService() {
    @Inject lateinit var serviceViewModel: ServiceViewModel
    @Inject lateinit var app: Application

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        disposable.add(Observable.interval(1, TimeUnit.SECONDS).subscribe {
            serviceViewModel.subject.onNext(it.toString())
        })
        return super.onStartCommand(intent, flags, startId)
    }
}