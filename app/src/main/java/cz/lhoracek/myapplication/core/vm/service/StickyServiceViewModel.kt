package cz.lhoracek.myapplication.core.vm.service

import androidx.databinding.ObservableField
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StickyServiceViewModel @Inject constructor() : BaseServiceViewModel()  {
    val observableField = ObservableField<String>()
}