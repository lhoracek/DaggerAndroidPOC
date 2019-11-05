package com.generalbytes.myapplication.service

import android.content.Intent
import android.os.IBinder
import com.generalbytes.myapplication.vm.ProcessServiceViewModel
import dagger.android.DaggerService
import io.reactivex.Observable
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class DifferentProcessService: DaggerService(){
    @Inject
    lateinit var serviceViewModel: ProcessServiceViewModel

    override fun onBind(p0: Intent?): IBinder? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Observable.interval(2, TimeUnit.SECONDS).subscribe { it -> serviceViewModel.subject.onNext(it.toString())}
        return super.onStartCommand(intent, flags, startId)
    }
}