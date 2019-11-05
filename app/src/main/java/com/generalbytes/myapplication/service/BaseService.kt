package com.generalbytes.myapplication.service

import android.content.Intent
import android.os.IBinder
import dagger.android.DaggerService
import io.reactivex.disposables.CompositeDisposable


abstract class BaseService: DaggerService() {
    protected val disposable = CompositeDisposable()

    override fun onBind(p0: Intent?): IBinder? {
        // nothing
        throw UnsupportedOperationException("Binding not expected")
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }
}