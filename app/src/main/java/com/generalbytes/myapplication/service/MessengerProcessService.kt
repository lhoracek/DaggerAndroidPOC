package com.generalbytes.myapplication.service

import android.app.Application
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.*
import com.generalbytes.myapplication.vm.service.MessengerProcessServiceViewModel
import io.reactivex.Observable
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

class MessengerProcessService : BaseService<MessengerProcessServiceViewModel>() {
    @Inject lateinit var app: Application
    val serviceMessenger =  Messenger(IncomingHandler())

    companion object{
        const val MSG_DATA = 1
        const val MSG_DATA_EXTRA = "Extra"
    }

    @Singleton
    class MessengerProcessServiceManager @Inject constructor(): BaseServiceManager<MessengerProcessServiceViewModel>(MessengerProcessService::class.java) {
        val managerMessenger =  Messenger(IncomingHandler())
        internal inner class IncomingHandler : Handler() {
            override fun handleMessage(msg: Message) {
                when (msg.what) {
                    MSG_DATA -> Timber.d("ServiceManager just got message")
                    else -> super.handleMessage(msg)
                }
            }
        }


        private val serviceConnection = object : ServiceConnection {
            override fun onServiceConnected(
                className: ComponentName,
                service: IBinder
            ) {
                val remoteService = Messenger(service)
                Timber.d("Service just connected")

                try {
                    var msg = Message.obtain(null, MSG_DATA)
                    msg.replyTo = managerMessenger
                    remoteService.send(msg)
                } catch (e: RemoteException) {
                   // TODO
                }
            }

            override fun onServiceDisconnected(className: ComponentName) {
                Timber.d("Service just disconnected")
            }
        }

        override fun start(){
            super.start()
            app.bindService(createIntent(), serviceConnection, Context.BIND_AUTO_CREATE)
        }

        override fun stop(){
            app.unbindService(serviceConnection)
            super.stop()
        }
    }

    val clients = mutableListOf<Messenger>()

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        disposable.add(Observable.interval(1, TimeUnit.SECONDS)
            .subscribe {
                val bundle = Bundle()
                bundle.putInt(MSG_DATA_EXTRA, it.toInt())
                clients.forEach { it.send(Message.obtain(null, MSG_DATA)) }
            })
        return super.onStartCommand(intent, flags, startId)
    }

    internal inner class IncomingHandler : Handler() {
        override fun handleMessage(msg: Message) {
            Timber.d("Service just got message")
            clients.add(msg.replyTo)
        }
    }

    override fun onBind(p0: Intent?): IBinder? = serviceMessenger.binder
}