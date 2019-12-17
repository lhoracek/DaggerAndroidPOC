package com.generalbytes.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import com.generalbytes.myapplication.R
import com.generalbytes.myapplication.databinding.ActivityFirstBinding
import com.generalbytes.myapplication.di.modules.ActivityScope
import com.generalbytes.myapplication.vm.activity.ActivityViewModel
import dagger.Binds
import dagger.Module

class FirstActivity: BaseActivity<ActivityFirstBinding, ActivityViewModel>(R.layout.activity_first) {

    @Module(includes = [BaseActivity.InjectionModule::class])
    abstract class InjectionModule {
        @Binds @ActivityScope
        internal abstract fun bindAppCompatActivity(activity: FirstActivity): AppCompatActivity
    }
}
