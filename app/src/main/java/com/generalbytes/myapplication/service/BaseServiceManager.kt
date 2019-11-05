package com.generalbytes.myapplication.service

import android.app.Application
import android.app.Service
import android.content.Intent
import javax.inject.Inject


abstract class BaseServiceManager<T>(val serviceClass: Class<out Service>){

    @Inject protected lateinit var app: Application

    protected open fun createIntent(): Intent{
        return Intent(app,serviceClass)
    }

    open fun start() {
        app.startService(createIntent())
    }

    open fun stop(){
        app.stopService(createIntent())
    }
}