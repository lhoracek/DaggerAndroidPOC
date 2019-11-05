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
    val serviceViewModel: ServiceViewModel
) : BaseViewModel() {
    val text = ObservableField<String>("")
    val textProcess = ObservableField<String>("")

    init {
        disposable.add(serviceViewModel.subject.subscribe {
            Timber.d("Sticky" + it)
            text.set(it)
        })
    }
}