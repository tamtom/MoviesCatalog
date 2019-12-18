package com.tamimi.movies.di

import com.tamimi.movies.MoviesApplication
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * Created by omaraltamimi on 17,December,2019
 */
@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityBuildersModule::class])
interface AppComponent : AndroidInjector<MoviesApplication> {

    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<MoviesApplication>

}