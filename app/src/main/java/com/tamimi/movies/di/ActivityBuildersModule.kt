package com.tamimi.movies.di

import com.tamimi.movies.ui.HostActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by omaraltamimi on 17,December,2019
 */
@Module
abstract class ActivityBuildersModule {
    @ContributesAndroidInjector(modules = [(FragmentBuildersModule::class)])
    abstract fun contributeMainActivity(): HostActivity
}