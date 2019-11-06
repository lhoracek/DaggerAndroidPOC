package com.generalbytes.myapplication.vm.fragment

import com.generalbytes.myapplication.model.SystemWideAPI
import com.generalbytes.myapplication.vm.BaseViewModel
import com.generalbytes.myapplication.vm.service.StickyServiceViewModel
import javax.inject.Inject


class FirstFragmentViewModel @Inject constructor(
    val serviceViewModel: StickyServiceViewModel,
    val API: SystemWideAPI
) : BaseViewModel() {
    val apiValue = API.getData()
}