package com.generalbytes.myapplication.di

import com.generalbytes.myapplication.fragment.FirstFragment
import com.generalbytes.myapplication.fragment.SecondFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentsModule {
    @ContributesAndroidInjector()
    abstract fun contributeFragmentActivityAndroidInjector(): FirstFragment

    @ContributesAndroidInjector()
    abstract fun contributeFragmentTwoActivityAndroidInjector(): SecondFragment
}