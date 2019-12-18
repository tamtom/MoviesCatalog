package com.tamimi.movies.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tamimi.movies.viewmodels.MoviesDetailsViewModel
import com.tamimi.movies.viewmodels.MoviesViewModel
import com.tamimi.movies.viewmodels.MoviesViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by omaraltamimi on 18,December,2019
 */
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: MoviesViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MoviesDetailsViewModel::class)
    abstract fun bindMensViewModel(moviesDetailsViewModel: MoviesDetailsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MoviesViewModel::class)
    abstract fun bindWomensViewModel(moviesDetailsViewModel: MoviesViewModel): ViewModel

}