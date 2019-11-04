package com.generalbytes.myapplication.fragment

import androidx.fragment.app.Fragment
import com.generalbytes.myapplication.R
import com.generalbytes.myapplication.databinding.FragmentBinding
import com.generalbytes.myapplication.di.FragmentScope
import com.generalbytes.myapplication.vm.FragmentViewModel
import dagger.Binds
import dagger.Module
import javax.inject.Inject


class SecondFragment: BaseFragment<FragmentBinding, FragmentViewModel>(R.layout.fragment) {
    @Inject lateinit var vm: FragmentViewModel
    override fun createViewModel() = vm

    @Module
    abstract class InjectionModule {
        @Binds
        @FragmentScope
        internal abstract fun bindFragment(fragment: SecondFragment): Fragment
    }
}