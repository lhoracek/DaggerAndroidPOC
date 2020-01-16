package cz.lhoracek.myapplication.example.fragment

import cz.lhoracek.myapplication.core.model.ApiInterface
import cz.lhoracek.myapplication.core.vm.BaseViewModel
import cz.lhoracek.myapplication.core.vm.service.ResultReceiverServiceViewModel
import javax.inject.Inject


class SecondFragmentViewModel @Inject constructor(
    val serviceViewModel: ResultReceiverServiceViewModel,
    val API: ApiInterface
): BaseViewModel(){
    val apiValue = API.getData()
}