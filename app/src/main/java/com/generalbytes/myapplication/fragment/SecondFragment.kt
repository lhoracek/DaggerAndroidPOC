package com.generalbytes.myapplication.fragment

import com.generalbytes.myapplication.R
import com.generalbytes.myapplication.databinding.FragmentBinding
import com.generalbytes.myapplication.vm.FragmentViewModel
import javax.inject.Inject


class SecondFragment: BaseFragment<FragmentBinding, FragmentViewModel>(R.layout.fragment) {
    @Inject lateinit var vm: FragmentViewModel
    override fun createViewModel() = vm
}