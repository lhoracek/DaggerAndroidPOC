package cz.lhoracek.myapplication.example.activity

import androidx.appcompat.app.AppCompatActivity
import cz.lhoracek.myapplication.R
import cz.lhoracek.myapplication.core.activity.BaseActivity
import cz.lhoracek.myapplication.core.di.modules.ActivityScope
import cz.lhoracek.myapplication.databinding.ActivityFirstBinding
import dagger.Binds
import dagger.Module

class FirstActivity: BaseActivity<ActivityFirstBinding, ActivityViewModel>(R.layout.activity_first) {

    @Module(includes = [BaseActivity.InjectionModule::class])
    abstract class InjectionModule {
        @Binds @ActivityScope
        internal abstract fun bindAppCompatActivity(activity: FirstActivity): AppCompatActivity
    }
}
