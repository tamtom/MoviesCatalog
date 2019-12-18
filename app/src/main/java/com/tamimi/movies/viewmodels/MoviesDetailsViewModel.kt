package com.tamimi.movies.viewmodels

import androidx.lifecycle.ViewModel
import com.tamimi.movies.repository.MovieDetailsRepository
import javax.inject.Inject

class MoviesDetailsViewModel @Inject constructor(val movieDetailsRepository: MovieDetailsRepository) :
    ViewModel() {

}