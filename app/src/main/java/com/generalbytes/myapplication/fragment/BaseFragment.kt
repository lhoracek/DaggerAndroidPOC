package com.generalbytes.myapplication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.generalbytes.myapplication.BR
import com.generalbytes.myapplication.di.FragmentScopeModule
import dagger.Module
import dagger.android.support.DaggerFragment
import io.reactivex.disposables.CompositeDisposable


abstract class BaseFragment<T : ViewDataBinding, V : Any>(val layoutId: Int) : DaggerFragment() {

    protected val disposables = CompositeDisposable()
    protected lateinit var binding: T
    protected lateinit var viewModel: V

    @Module(includes = [FragmentScopeModule::class])
    abstract class InjectionModule {
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, layoutId, null, false)
        viewModel = createViewModel()
        bindModel()
        return binding.root
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