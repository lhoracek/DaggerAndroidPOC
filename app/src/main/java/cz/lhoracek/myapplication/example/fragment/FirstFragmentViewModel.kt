package cz.lhoracek.myapplication.example.fragment

import cz.lhoracek.myapplication.core.model.ApiInterface
import cz.lhoracek.myapplication.core.vm.BaseViewModel
import cz.lhoracek.myapplication.core.vm.service.StickyServiceViewModel
import javax.inject.Inject


class FirstFragmentViewModel @Inject constructor(
    val serviceViewModel: StickyServiceViewModel,
    val API: ApiInterface
) : BaseViewModel() {
    val apiValue = API.getData()
    val clickHandler:()-> Unit = {}
}