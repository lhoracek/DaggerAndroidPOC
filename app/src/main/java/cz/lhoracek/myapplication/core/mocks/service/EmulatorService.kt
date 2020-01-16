package cz.lhoracek.myapplication.core.mocks.service

import android.app.Application
import cz.lhoracek.myapplication.core.service.BaseServiceManager
import cz.lhoracek.myapplication.core.service.IStickyServiceManager
import cz.lhoracek.myapplication.core.service.StickyService
import cz.lhoracek.myapplication.core.vm.service.StickyServiceViewModel
import javax.inject.Inject


class EmulatorStickyService: StickyService() {
    class EmulatorStickyServiceManager @Inject constructor(
        app: Application,
        viewModel: StickyServiceViewModel
    ): BaseServiceManager<StickyServiceViewModel>(app, viewModel, EmulatorStickyService::class.java), IStickyServiceManager

    override fun getValue(num: Long) = "Emulator sticky service $num"
}