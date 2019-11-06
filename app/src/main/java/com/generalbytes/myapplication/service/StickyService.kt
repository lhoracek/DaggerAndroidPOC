package com.generalbytes.myapplication.service

import android.app.Application
import android.content.Intent
import com.generalbytes.myapplication.vm.service.StickyServiceViewModel
import io.reactivex.Observable
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton


class StickyService : BaseService<StickyServiceViewModel>() {
    @Inject lateinit var app: Application

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        disposable.add(Observable.interval(1, TimeUnit.SECONDS).subscribe {
            vm.observableField.set("Sticky service: $it")
        })
        return super.onStartCommand(intent, flags, startId)
    }

    @Singleton
    class StickyServiceManager @Inject constructor(
        app: Application,
        viewModel: StickyServiceViewModel
    ) : BaseServiceManager<StickyServiceViewModel>(app,viewModel, StickyService::class.java) {}
}