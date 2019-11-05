package com.generalbytes.myapplication.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.generalbytes.myapplication.R
import com.generalbytes.myapplication.databinding.ActivityBinding
import com.generalbytes.myapplication.di.ActivityScope
import com.generalbytes.myapplication.service.DifferentProcessService
import com.generalbytes.myapplication.service.MessengerProcessService
import com.generalbytes.myapplication.vm.ActivityViewModel
import dagger.Binds
import dagger.Module
import javax.inject.Inject

class FirstActivity: BaseActivity<ActivityBinding, ActivityViewModel>(R.layout.activity) {
    @Inject lateinit var differentProcessServiceManager: DifferentProcessService.DifferentProcessServiceManager
    @Inject lateinit var messengerProcessServiceManager: MessengerProcessService.MessengerProcessServiceManager

    @Module(includes = [BaseActivity.InjectionModule::class])
    abstract class InjectionModule {
        @Binds @ActivityScope internal abstract fun bindAppCompatActivity(activity: FirstActivity): AppCompatActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // startService(Intent(this, StickyService::class.java))
        messengerProcessServiceManager.start()
        // startService(Intent(this, DifferentProcessService::class.java))
    }
}
