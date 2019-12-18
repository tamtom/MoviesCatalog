package com.tamimi.movies.di

import com.tamimi.movies.ui.MoviesDetailsFragment
import com.tamimi.movies.ui.MoviesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by omaraltamimi on 17,December,2019
 */
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeSportFragment(): MoviesFragment

    @ContributesAndroidInjector
    abstract fun contributeNewsFragment(): MoviesDetailsFragment
}