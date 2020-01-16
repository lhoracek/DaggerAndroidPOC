package cz.lhoracek.myapplication.core.service

import android.app.Application
import android.content.Intent
import cz.lhoracek.myapplication.core.vm.service.StickyServiceViewModel
import io.reactivex.Observable
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton


open class StickyService : BaseService<StickyServiceViewModel>() {
    @Inject
    lateinit var app: Application

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        disposable.add(Observable.interval(1, TimeUnit.SECONDS).subscribe {
            vm.observableField.set(getValue(it))
        })
        return super.onStartCommand(intent, flags, startId)
    }


    protected open fun getValue(num: Long) = "Sticky service: $num"


    @Singleton
    open class StickyServiceManager @Inject constructor(
        app: Application,
        viewModel: StickyServiceViewModel
    ) : BaseServiceManager<StickyServiceViewModel>(app, viewModel, StickyService::class.java), IStickyServiceManager
}

interface  IStickyServiceManager: IBaseServiceManager {

}