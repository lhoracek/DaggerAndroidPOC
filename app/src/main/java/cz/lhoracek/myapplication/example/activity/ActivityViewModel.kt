package cz.lhoracek.myapplication.example.activity

import androidx.databinding.ObservableBoolean
import cz.lhoracek.myapplication.core.service.IStickyServiceManager
import cz.lhoracek.myapplication.core.service.MessengerProcessService
import cz.lhoracek.myapplication.core.service.ResultReceiverProcessService
import cz.lhoracek.myapplication.core.vm.BaseViewModel
import cz.lhoracek.myapplication.core.vm.service.MessengerProcessServiceViewModel
import cz.lhoracek.myapplication.core.vm.service.ResultReceiverServiceViewModel
import cz.lhoracek.myapplication.core.vm.service.StickyServiceViewModel
import javax.inject.Inject

class ActivityViewModel @Inject constructor(
    val stickyServiceViewModel: StickyServiceViewModel,
    val resultReceiverServiceViewModel: ResultReceiverServiceViewModel,
    val messengerProcessServiceViewModel: MessengerProcessServiceViewModel,
    val stickyServiceManager: IStickyServiceManager,
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