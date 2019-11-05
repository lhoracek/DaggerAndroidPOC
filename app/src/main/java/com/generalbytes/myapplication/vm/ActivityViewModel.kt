package com.generalbytes.myapplication.vm

import androidx.databinding.ObservableField
import com.generalbytes.myapplication.model.First
import com.generalbytes.myapplication.model.Second
import com.generalbytes.myapplication.model.Third
import timber.log.Timber
import javax.inject.Inject

class ActivityViewModel @Inject constructor(
    val firstNumber: First,
    val secondNumber: Second,
    val thirdNumber: Third,
    val serviceViewModel: ServiceViewModel,
    val processServiceViewModel: ProcessServiceViewModel
) {
    val text = ObservableField<String>("")
    val textProcess = ObservableField<String>("")

    init {
        serviceViewModel.subject.subscribe { it -> {
            Timber.d("Sticky" + it)
            text.set(it)
        }}
        processServiceViewModel.subject.subscribe{it -> {
            Timber.d("Process" + it)
            textProcess.set(it)
        }}
    }
}