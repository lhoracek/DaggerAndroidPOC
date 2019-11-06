package com.generalbytes.myapplication.vm.service

import androidx.databinding.ObservableField
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MessengerProcessServiceViewModel @Inject constructor() : BaseServiceViewModel() {
    val observableField = ObservableField<String>()
}