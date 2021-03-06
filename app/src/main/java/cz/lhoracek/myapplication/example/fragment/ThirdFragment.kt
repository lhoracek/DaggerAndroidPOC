package cz.lhoracek.myapplication.example.fragment

import androidx.fragment.app.Fragment
import cz.lhoracek.myapplication.R
import cz.lhoracek.myapplication.core.di.modules.FragmentScope
import cz.lhoracek.myapplication.core.fragment.BaseFragment
import cz.lhoracek.myapplication.core.model.ApiInterface
import cz.lhoracek.myapplication.databinding.FragmentSecondBinding
import dagger.Binds
import dagger.Module
import javax.inject.Inject


class ThirdFragment : BaseFragment<FragmentSecondBinding, ThirdFragmentViewModel>(R.layout.fragment_third) {
    @Inject lateinit var API: ApiInterface

    @Module(includes = [BaseFragment.InjectionModule::class])
    abstract class InjectionModule {
        @Binds
        @FragmentScope
        internal abstract fun bindFragment(fragment: ThirdFragment): Fragment
    }
}