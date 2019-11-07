package com.generalbytes.myapplication.vm.fragment

import com.generalbytes.myapplication.model.ApiInterface
import com.generalbytes.myapplication.vm.BaseViewModel
import com.generalbytes.myapplication.vm.service.StickyServiceViewModel
import javax.inject.Inject


class FirstFragmentViewModel @Inject constructor(
    val serviceViewModel: StickyServiceViewModel,
    val API: ApiInterface
) : BaseViewModel() {
    val apiValue = API.getData()
}