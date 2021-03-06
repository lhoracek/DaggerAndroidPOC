package cz.lhoracek.myapplication.core.vm

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber


abstract class BaseViewModel: ViewModel() {
    protected val disposable = CompositeDisposable()

    public override fun onCleared() {
        super.onCleared()
        Timber.d("Called clear on ${this.toString()}")
        disposable.dispose()
    }
}