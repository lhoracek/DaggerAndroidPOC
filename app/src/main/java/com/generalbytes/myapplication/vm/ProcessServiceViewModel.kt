package com.generalbytes.myapplication.vm

import io.reactivex.subjects.PublishSubject
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProcessServiceViewModel @Inject constructor()  {
    val subject = PublishSubject.create<String>()
}