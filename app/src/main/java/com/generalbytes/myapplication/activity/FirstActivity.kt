package com.generalbytes.myapplication.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.generalbytes.myapplication.R
import com.generalbytes.myapplication.databinding.ActivityBinding
import com.generalbytes.myapplication.di.ActivityScope
import com.generalbytes.myapplication.service.StickyService
import com.generalbytes.myapplication.vm.ActivityViewModel
import dagger.Binds
import dagger.Module
import javax.inject.Inject

class FirstActivity: BaseActivity<ActivityBinding, ActivityViewModel>(R.layout.activity) {

    @Inject lateinit var vm: ActivityViewModel

    override fun createViewModel() = vm

    @Module(includes = [BaseActivity.InjectionModule::class])
    abstract class InjectionModule {
        @Binds @ActivityScope internal abstract fun bindAppCompatActivity(activity: FirstActivity): AppCompatActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startService(Intent(this, StickyService::class.java))
       // startService(Intent(this, DifferentProcessService::class.java))
    }
}
