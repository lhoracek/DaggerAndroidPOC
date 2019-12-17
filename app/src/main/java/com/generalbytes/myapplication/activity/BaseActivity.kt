package com.generalbytes.myapplication.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.generalbytes.myapplication.BR
import com.generalbytes.myapplication.di.modules.ActivityScopeModule
import com.generalbytes.myapplication.vm.createFactory
import dagger.Module
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


abstract class BaseActivity<T: ViewDataBinding, V: ViewModel>(val layoutId: Int): DaggerAppCompatActivity() {

    protected val disposables = CompositeDisposable()
    protected lateinit var binding: T
    @Inject protected lateinit var viewModel: V

    @Module(includes = [ActivityScopeModule::class])
    abstract class InjectionModule {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        ViewModelProviders.of(this, viewModel.createFactory()).get(viewModel.javaClass)
        bindModel()
    }

    protected fun bindModel() = binding.setVariable(BR.viewModel, viewModel)

    override fun onPause() {
        super.onPause()
        disposables.dispose()
    }
}