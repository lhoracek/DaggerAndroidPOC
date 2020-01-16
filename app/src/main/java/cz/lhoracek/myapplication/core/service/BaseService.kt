package cz.lhoracek.myapplication.core.service

import android.content.Intent
import android.os.IBinder
import cz.lhoracek.myapplication.core.vm.service.BaseServiceViewModel
import dagger.android.DaggerService
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


abstract class BaseService<T : BaseServiceViewModel> : DaggerService() {
    @Inject lateinit var vm: T
    protected val disposable = CompositeDisposable()

    override fun onBind(p0: Intent?): IBinder? {
        // nothing
        throw UnsupportedOperationException("Binding not expected")
    }

    override fun onDestroy() {
        super.onDestroy()
        vm.running.set(false)
        disposable.dispose()
        vm.onCleared()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        vm.running.set(true)
        return super.onStartCommand(intent, flags, startId)
    }
}