package cz.lhoracek.myapplication.core.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


/**
 * This class allow to use ViewModelProvider that registers the instance of
 * viewModel through ViewModelLoader using lifecycle extensions of Android.
 * It will allow us to use RxJava disposables in viewModel, as Android calls @ViewModel.onClear()
 * on the viewModel when it's not going to be used anymore.
 */
fun <T: ViewModel> T.createFactory(): ViewModelProvider.Factory {
    val viewModel = this
    return object: ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T: ViewModel> create(modelClass: Class<T>): T = viewModel as T
    }
}