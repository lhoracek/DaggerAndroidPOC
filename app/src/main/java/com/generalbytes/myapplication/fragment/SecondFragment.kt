package com.generalbytes.myapplication.fragment

import androidx.fragment.app.Fragment
import com.generalbytes.myapplication.R
import com.generalbytes.myapplication.databinding.FragmentSecondBinding
import com.generalbytes.myapplication.di.FragmentScope
import com.generalbytes.myapplication.model.SystemWideAPI
import com.generalbytes.myapplication.vm.fragment.SecondFragmentViewModel
import dagger.Binds
import dagger.Module
import javax.inject.Inject


class SecondFragment : BaseFragment<FragmentSecondBinding, SecondFragmentViewModel>(R.layout.fragment_second) {
    @Inject lateinit var API: SystemWideAPI

    @Module(includes = [BaseFragment.InjectionModule::class])
    abstract class InjectionModule {
        @Binds
        @FragmentScope
        internal abstract fun bindFragment(fragment: SecondFragment): Fragment
    }
}