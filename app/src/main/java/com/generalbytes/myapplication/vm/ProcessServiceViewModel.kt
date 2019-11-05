package com.generalbytes.myapplication.vm

import androidx.lifecycle.ViewModel
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProcessServiceViewModel @Inject constructor() : ViewModel() {
    val subject = PublishSubject.create<String>()
}