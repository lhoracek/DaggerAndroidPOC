package com.generalbytes.myapplication.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.generalbytes.myapplication.BR
import dagger.android.AndroidInjection
import io.reactivex.disposables.CompositeDisposable


abstract class BaseActivity<T: ViewDataBinding, V: Any>(val layoutId: Int): AppCompatActivity() {

    protected val disposables = CompositeDisposable()
    protected lateinit var binding: T
    protected lateinit var viewModel: V

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        viewModel = createViewModel()
        bindModel()
    }

    protected fun bindModel() {
        binding.setVariable(BR.viewModel, viewModel)
    }

    abstract fun createViewModel(): V

    override fun onPause() {
        super.onPause()
        disposables.dispose()
    }
}