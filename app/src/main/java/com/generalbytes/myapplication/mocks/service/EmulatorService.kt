package com.generalbytes.myapplication.mocks.service

import android.app.Application
import com.generalbytes.myapplication.service.BaseServiceManager
import com.generalbytes.myapplication.service.IStickyServiceManager
import com.generalbytes.myapplication.service.StickyService
import com.generalbytes.myapplication.vm.service.StickyServiceViewModel
import javax.inject.Inject


class EmulatorStickyService: StickyService() {
    class EmulatorStickyServiceManager @Inject constructor(
        app: Application,
        viewModel: StickyServiceViewModel
    ): BaseServiceManager<StickyServiceViewModel>(app, viewModel, EmulatorStickyService::class.java), IStickyServiceManager

    override fun getValue(num: Long) = "Emulator sticky service $num"
}