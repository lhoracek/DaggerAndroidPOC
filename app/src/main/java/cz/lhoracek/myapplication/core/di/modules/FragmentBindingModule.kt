package cz.lhoracek.myapplication.core.di.modules

import cz.lhoracek.myapplication.example.fragment.FirstFragment
import cz.lhoracek.myapplication.example.fragment.SecondFragment
import cz.lhoracek.myapplication.example.fragment.ThirdFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Scope


@Scope
@Retention
annotation class FragmentScope

@Module
abstract class FragmentBindingModule {
    @ContributesAndroidInjector(modules = [FirstFragment.InjectionModule::class])
    @FragmentScope
    abstract fun firstFragment(): FirstFragment

    @ContributesAndroidInjector(modules = [SecondFragment.InjectionModule::class])
    @FragmentScope
    abstract fun secondFragment(): SecondFragment

    @ContributesAndroidInjector(modules = [SecondFragment.InjectionModule::class])
    @FragmentScope
    abstract fun thirdFragment(): ThirdFragment
}

@Module
class FragmentScopeModule {

}