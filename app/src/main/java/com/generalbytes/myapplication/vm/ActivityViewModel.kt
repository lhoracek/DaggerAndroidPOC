package com.generalbytes.myapplication.vm

import androidx.databinding.ObservableField
import com.generalbytes.myapplication.model.First
import com.generalbytes.myapplication.model.Second
import com.generalbytes.myapplication.model.Third
import javax.inject.Inject


class ActivityViewModel @Inject constructor(
    val firstNumber: First,
    val secondNumber: Second,
    val thirdNumber: Third,
    val serviceViewModel: ServiceViewModel
) {
    val text = ObservableField<String>("")

    init {
        serviceViewModel.subject.subscribe({ it -> text.set(it)})
    }
}