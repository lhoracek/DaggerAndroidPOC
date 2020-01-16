package cz.lhoracek.myapplication.core.di.modules

import androidx.appcompat.app.AppCompatActivity
import cz.lhoracek.myapplication.example.activity.FirstActivity
import cz.lhoracek.myapplication.example.activity.SecondActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Scope

@Scope
@Retention
annotation class ActivityScope

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector(modules = [FirstActivity.InjectionModule::class])
    @ActivityScope
    abstract fun firstActivity(): FirstActivity

    @ContributesAndroidInjector(modules = [SecondActivity.InjectionModule::class])
    @ActivityScope
    abstract fun secondActivity(): SecondActivity
}

@Module(includes = [FragmentBindingModule::class])
class ActivityScopeModule {

    @Provides
    @ActivityScope
    fun provideFragmentManager(activity: AppCompatActivity) = activity.supportFragmentManager
}