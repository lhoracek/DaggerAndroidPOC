package com.generalbytes.myapplication.fragment

import androidx.fragment.app.FragmentManager
import com.generalbytes.myapplication.R
import com.generalbytes.myapplication.databinding.FragmentBinding
import com.generalbytes.myapplication.vm.FragmentViewModel
import javax.inject.Inject


class FirstFragment: BaseFragment<FragmentBinding, FragmentViewModel>(R.layout.fragment) {

    @Inject lateinit var fragmentManagerInjected: FragmentManager
    @Inject lateinit var vm: FragmentViewModel
    override fun createViewModel() = vm
}