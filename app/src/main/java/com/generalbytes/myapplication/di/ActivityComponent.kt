package com.generalbytes.myapplication.di

import dagger.Subcomponent
import javax.inject.Scope

@Scope
@Retention
annotation class ActivityScope

@ActivityScope
@Subcomponent(modules = [ActivitiesModule::class])
interface ActivityComponent {
}