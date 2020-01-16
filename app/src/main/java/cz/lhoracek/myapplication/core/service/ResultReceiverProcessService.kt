package cz.lhoracek.myapplication.core.service

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.os.ResultReceiver
import cz.lhoracek.myapplication.core.vm.service.ResultReceiverServiceViewModel
import io.reactivex.Observable
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton


/**
 * This service offers one way communication (more suitable for intent service
 * performing some long running job and reporting progress)
 */
class ResultReceiverProcessService : BaseService<ResultReceiverServiceViewModel>() {
    @Singleton
    class ResultReceiverServiceManager @Inject constructor(
        app: Application,
        viewModel: ResultReceiverServiceViewModel
    ) : BaseReceiverServiceManager<ResultReceiverServiceViewModel>(app, viewModel, ResultReceiverProcessService::class.java) {
        override fun handleData(resultData: Bundle?) {
            viewModel.observableField.set(resultData?.getInt(EXTRA_DATA).toString())
        }
    }

    lateinit var receiver: ResultReceiver

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // TODO if we kill the app, intent redelivery does not work correctly, receiver is null
        receiver = intent!!.getParcelableExtra(BaseReceiverServiceManager.EXTRA_RECEIVER)!!
        disposable.add(Observable.interval(1, TimeUnit.SECONDS)
            .subscribe {
                val bundle = Bundle()
                bundle.putInt(BaseReceiverServiceManager.EXTRA_DATA, it.toInt())
                receiver.send(BaseServiceManager.DATA, bundle)
            })
        receiver.send(BaseServiceManager.START, null)
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        receiver.send(BaseServiceManager.STOP, null)
        super.onDestroy()
    }
}