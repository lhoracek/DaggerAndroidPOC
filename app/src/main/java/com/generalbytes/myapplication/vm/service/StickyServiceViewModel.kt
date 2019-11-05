package com.generalbytes.myapplication.vm.service

import androidx.databinding.ObservableField
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StickyServiceViewModel @Inject constructor() : BaseServiceViewModel()  {
    val subject = PublishSubject.create<String>()
    val observableField = ObservableField<String>()
    init {
        disposable.add(subject.subscribe { observableField.set(it) })
    }
}