package com.generalbytes.myapplication.vm

import io.reactivex.subjects.PublishSubject
import javax.inject.Singleton

@Singleton
class ServiceViewModel {
    val subject = PublishSubject.create<String>()
}