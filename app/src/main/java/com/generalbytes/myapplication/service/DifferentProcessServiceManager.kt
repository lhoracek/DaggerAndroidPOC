package com.generalbytes.myapplication.service

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.ResultReceiver
import com.generalbytes.myapplication.vm.ProcessServiceViewModel
import javax.inject.Inject


class DifferentProcessServiceManager @Inject constructor(
    val app: Application,
    val viewModel: ProcessServiceViewModel
) {
    private val receiver = object : ResultReceiver(Handler()) {
        override fun onReceiveResult(resultCode: Int, resultData: Bundle?) {
            super.onReceiveResult(resultCode, resultData)
            viewModel.subject.onNext(resultData?.getInt(DifferentProcessService.EXTRA_DATA).toString())
        }
    }

    fun start() {
        val intent = Intent(app, DifferentProcessService::class.java)
        intent.putExtra(DifferentProcessService.EXTRA_RECEIVER, receiver)
        app.startService(intent)
    }

}