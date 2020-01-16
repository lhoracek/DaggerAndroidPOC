package cz.lhoracek.myapplication.example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import cz.lhoracek.myapplication.R
import cz.lhoracek.myapplication.core.di.modules.FragmentScope
import cz.lhoracek.myapplication.core.fragment.BaseFragment
import cz.lhoracek.myapplication.databinding.FragmentFirstBinding
import dagger.Binds
import dagger.Module


class FirstFragment: BaseFragment<FragmentFirstBinding, FirstFragmentViewModel>(R.layout.fragment_first) {

    @Module(includes = [BaseFragment.InjectionModule::class])
    abstract class InjectionModule {
        @Binds @FragmentScope
        internal abstract fun bindFragment(fragment: FirstFragment): Fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}