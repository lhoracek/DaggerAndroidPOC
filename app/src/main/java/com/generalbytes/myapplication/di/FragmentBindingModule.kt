package com.generalbytes.myapplication.di

import androidx.fragment.app.Fragment
import com.generalbytes.myapplication.fragment.FirstFragment
import com.generalbytes.myapplication.fragment.SecondFragment
import com.generalbytes.myapplication.model.Fifth
import com.generalbytes.myapplication.model.Fourth
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Scope


@Scope
@Retention
annotation class FragmentScope

@Module
abstract class FragmentBindingModule {
    @ContributesAndroidInjector(modules = [FragmentScopeModule::class])
    @FragmentScope
    abstract fun firstFragment(): FirstFragment

    @ContributesAndroidInjector(modules = [FragmentScopeModule::class])
    @FragmentScope
    abstract fun secondFragment(): SecondFragment
}

@Module
class FragmentScopeModule {
    @Provides
    @FragmentScope
    fun provideFourthNum() = Fourth(ApplicationModule.numberFactory())

    @Provides
    fun provideNewInstanceFragmentOnly() = Fifth(ApplicationModule.numberFactory())

    @Provides
    @FragmentScope
    fun provideFragment(fragment: Fragment) = fragment
}