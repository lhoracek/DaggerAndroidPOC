package com.generalbytes.myapplication.fragment

import androidx.fragment.app.Fragment
import com.generalbytes.myapplication.R
import com.generalbytes.myapplication.databinding.FragmentSecondBinding
import com.generalbytes.myapplication.di.FragmentScope
import com.generalbytes.myapplication.vm.fragment.ThirdFragmentViewModel
import dagger.Binds
import dagger.Module


class ThirdFragment : BaseFragment<FragmentSecondBinding, ThirdFragmentViewModel>(R.layout.fragment_third) {
    @Module(includes = [BaseFragment.InjectionModule::class])
    abstract class InjectionModule {
        @Binds
        @FragmentScope
        internal abstract fun bindFragment(fragment: ThirdFragment): Fragment
    }
}