package com.tamimi.movies

import com.tamimi.movies.di.AppComponent
import com.tamimi.movies.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Created by omaraltamimi on 17,December,2019
 */
class MoviesApplication : DaggerApplication() {
    private lateinit var appComponent: AppComponent

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val daggerAppComponent = DaggerAppComponent.factory().create(this)
        appComponent = daggerAppComponent as AppComponent
        return daggerAppComponent
    }
}