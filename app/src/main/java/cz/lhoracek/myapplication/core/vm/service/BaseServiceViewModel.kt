package cz.lhoracek.myapplication.core.vm.service

import androidx.databinding.ObservableBoolean
import cz.lhoracek.myapplication.core.vm.BaseViewModel


abstract class BaseServiceViewModel: BaseViewModel() {
    val running = ObservableBoolean(false)
}