package com.generalbytes.myapplication.vm

import androidx.databinding.ObservableField
import timber.log.Timber
import javax.inject.Inject

class ActivityViewModel @Inject constructor(
    val serviceViewModel: ServiceViewModel
) : BaseViewModel() {
    val text = ObservableField<String>("")

    init {
        disposable.add(serviceViewModel.subject.subscribe {
            Timber.d("Sticky" + it)
            text.set(it)
        })
    }
}