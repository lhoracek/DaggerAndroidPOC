package com.generalbytes.myapplication.vm.service

import io.reactivex.subjects.PublishSubject
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MessengerProcessServiceViewModel @Inject constructor() : BaseServiceViewModel() {
    val subject = PublishSubject.create<String>()
}