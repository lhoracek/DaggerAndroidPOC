package com.generalbytes.myapplication.vm.activity

import androidx.databinding.ObservableBoolean
import com.generalbytes.myapplication.service.MessengerProcessService
import com.generalbytes.myapplication.service.ResultReceiverProcessService
import com.generalbytes.myapplication.service.StickyService
import com.generalbytes.myapplication.vm.BaseViewModel
import com.generalbytes.myapplication.vm.service.MessengerProcessServiceViewModel
import com.generalbytes.myapplication.vm.service.ResultReceiverServiceViewModel
import com.generalbytes.myapplication.vm.service.StickyServiceViewModel
import javax.inject.Inject

class ActivityViewModel @Inject constructor(
    val stickyServiceViewModel: StickyServiceViewModel,
    val resultReceiverServiceViewModel: ResultReceiverServiceViewModel,
    val messengerProcessServiceViewModel: MessengerProcessServiceViewModel,
    val stickyServiceManager: StickyService.StickyServiceManager,
    val resultReceiverProcessServiceManager: ResultReceiverProcessService.ResultReceiverServiceManager,
    val messengerProcessServiceManager: MessengerProcessService.MessengerProcessServiceManager

) : BaseViewModel() {
    val stickyHandler: () -> Unit = { stickyServiceManager.let { if (stickyServiceViewModel.running.get()) it.stop() else it.start() } }
    val processHandler: () -> Unit = { resultReceiverProcessServiceManager.let { if (resultReceiverServiceViewModel.running.get()) it.stop() else it.start() } }
    val messengerHandler: () -> Unit = { messengerProcessServiceManager.let { if (messengerProcessServiceViewModel.running.get()) it.stop() else it.start() } }
    val allRunning = object : ObservableBoolean(
        stickyServiceViewModel.running,
        resultReceiverServiceViewModel.running,
        messengerProcessServiceViewModel.running
    ) {
        override fun notifyChange() {
            set(stickyServiceViewModel.running.get() &&
                resultReceiverServiceViewModel.running.get() &&
                messengerProcessServiceViewModel.running.get())
            super.notifyChange()
        }
    }
}