package com.tamimi.movies.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.tamimi.movies.R

import com.tamimi.movies.viewmodels.MoviesDetailsViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MoviesDetailsFragment : DaggerFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val moviesDetailsViewModel by viewModels<MoviesDetailsViewModel> { viewModelFactory }

    companion object {
        fun newInstance() = MoviesDetailsFragment()
    }

    private lateinit var viewModel: MoviesDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movies_details_fragment, container, false)
    }

}