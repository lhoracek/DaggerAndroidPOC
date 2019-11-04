package com.generalbytes.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.generalbytes.myapplication.di.AppComponent
import dagger.android.AndroidInjection
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var component: AppComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for(i in 0..10) Timber.d("First: $i "+component.getNumber().toString())
        for(i in 0..10) Timber.d("Second: $i "+component.getSecondNumber().toString())
    }
}
