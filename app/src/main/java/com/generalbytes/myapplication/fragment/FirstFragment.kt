package com.generalbytes.myapplication.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.generalbytes.myapplication.R
import com.generalbytes.myapplication.databinding.FragmentFirstBinding
import com.generalbytes.myapplication.di.FragmentScope
import com.generalbytes.myapplication.vm.fragment.FirstFragmentViewModel
import dagger.Binds
import dagger.Module
import javax.inject.Inject


class FirstFragment: BaseFragment<FragmentFirstBinding, FirstFragmentViewModel>(R.layout.fragment_first) {

    @Inject lateinit var fm: FragmentManager

    @Module(includes = [BaseFragment.InjectionModule::class])
    abstract class InjectionModule {
        @Binds @FragmentScope internal abstract fun bindFragment(fragment: FirstFragment): Fragment
    }
}