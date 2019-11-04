package com.generalbytes.myapplication

import android.os.Bundle
import com.generalbytes.myapplication.di.AppComponent
import timber.log.Timber
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject lateinit var component: AppComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for(i in 0..10) Timber.d("First: $i "+component.getNumber().toString())
        for(i in 0..10) Timber.d("Second: $i "+component.getSecondNumber().toString())
    }
}
