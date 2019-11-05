package com.generalbytes.myapplication.vm.service

import androidx.databinding.ObservableBoolean
import com.generalbytes.myapplication.vm.BaseViewModel


abstract class BaseServiceViewModel: BaseViewModel() {
    val running = ObservableBoolean(false)
}