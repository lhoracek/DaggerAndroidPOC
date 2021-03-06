package cz.lhoracek.myapplication.core.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import cz.lhoracek.myapplication.BR
import cz.lhoracek.myapplication.core.di.modules.FragmentScopeModule
import cz.lhoracek.myapplication.core.vm.createFactory
import dagger.Module
import dagger.android.support.DaggerFragment
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


abstract class BaseFragment<T : ViewDataBinding, V : ViewModel>(val layoutId: Int) : DaggerFragment() {

    protected val disposables = CompositeDisposable()
    protected lateinit var binding: T
    @Inject protected lateinit var viewModel: V

    @Module(includes = [FragmentScopeModule::class])
    abstract class InjectionModule {
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, layoutId, null, false)
        ViewModelProviders.of(this, viewModel.createFactory()).get(viewModel.javaClass)
        bindModel()
        return binding.root
    }

    protected fun bindModel() = binding.setVariable(BR.viewModel, viewModel)

    override fun onPause() {
        super.onPause()
        disposables.dispose()
    }
}