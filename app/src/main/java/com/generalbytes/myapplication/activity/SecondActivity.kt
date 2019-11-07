package com.generalbytes.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import com.generalbytes.myapplication.R
import com.generalbytes.myapplication.databinding.ActivityBinding
import com.generalbytes.myapplication.di.modules.ActivityScope
import com.generalbytes.myapplication.vm.activity.ActivityViewModel
import dagger.Binds
import dagger.Module

class SecondActivity: BaseActivity<ActivityBinding, ActivityViewModel>(R.layout.activity) {

    @Module(includes = [BaseActivity.InjectionModule::class])
    abstract class InjectionModule {
        @Binds
        @ActivityScope
        internal abstract fun bindAppCompatActivity(activity: SecondActivity): AppCompatActivity
    }
}
