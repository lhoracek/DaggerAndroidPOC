package cz.lhoracek.myapplication.example.fragment

import cz.lhoracek.myapplication.core.model.ApiInterface
import cz.lhoracek.myapplication.core.vm.BaseViewModel
import cz.lhoracek.myapplication.core.vm.service.MessengerProcessServiceViewModel
import javax.inject.Inject


class ThirdFragmentViewModel @Inject constructor(
    val serviceViewModel: MessengerProcessServiceViewModel,
    val API: ApiInterface
) : BaseViewModel() {
    val apiValue = API.getData()
}