package com.generalbytes.myapplication.vm.fragment

import com.generalbytes.myapplication.vm.BaseViewModel
import com.generalbytes.myapplication.vm.service.MessengerProcessServiceViewModel
import javax.inject.Inject


class ThirdFragmentViewModel @Inject constructor(
    val serviceViewModel: MessengerProcessServiceViewModel
): BaseViewModel()