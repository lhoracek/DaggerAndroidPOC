package com.generalbytes.myapplication.vm.fragment

import com.generalbytes.myapplication.vm.BaseViewModel
import com.generalbytes.myapplication.vm.service.ResultReceiverServiceViewModel
import javax.inject.Inject


class SecondFragmentViewModel @Inject constructor(
    val serviceViewModel: ResultReceiverServiceViewModel
): BaseViewModel()