package com.generalbytes.myapplication.di

import com.generalbytes.myapplication.fragment.FirstFragment
import com.generalbytes.myapplication.fragment.SecondFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Scope


@Scope
@Retention
annotation class FragmentScope

@Module
abstract class FragmentsModule {
    @ContributesAndroidInjector()
    @FragmentScope
    abstract fun contributeFragmentActivityAndroidInjector(): FirstFragment

    @ContributesAndroidInjector()
    @FragmentScope
    abstract fun contributeFragmentTwoActivityAndroidInjector(): SecondFragment
}