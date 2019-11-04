package com.generalbytes.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import com.generalbytes.myapplication.R
import com.generalbytes.myapplication.databinding.ActivityBinding
import com.generalbytes.myapplication.di.ActivityScope
import com.generalbytes.myapplication.vm.ActivityViewModel
import dagger.Binds
import dagger.Module
import javax.inject.Inject

class FirstActivity: BaseActivity<ActivityBinding, ActivityViewModel>(R.layout.activity) {

    @Module
    abstract class InjectionModule {
        @Binds
        @ActivityScope
        internal abstract fun bindAppCompatActivity(activity: FirstActivity): AppCompatActivity
    }

    @Inject lateinit var vm: ActivityViewModel

    override fun createViewModel() = vm
}
