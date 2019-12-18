package com.tamimi.movies.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tamimi.movies.model.Movie
import com.tamimi.movies.model.Resource
import com.tamimi.movies.model.SortBy
import com.tamimi.movies.model.Type
import com.tamimi.movies.repository.MoviesListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MoviesViewModel @Inject constructor(val moviesListRepository: MoviesListRepository) :
    ViewModel() {
    var popularMovies: MutableLiveData<Resource<List<Movie>>> = MutableLiveData()
    var topRated: MutableLiveData<Resource<List<Movie>>> = MutableLiveData()
    var topRevenue: MutableLiveData<Resource<List<Movie>>> = MutableLiveData()
    var popularPage = 0
    var topRatedPage = 0
    var revenuePage = 0
    init {
        viewModelScope.launch {
            moviesListRepository.inserTypes()

        }
    }
    fun isFirstPage(sortBy: SortBy): Boolean {
        when (sortBy) {
            SortBy.POPULARITY -> popularPage == 1
            SortBy.TOP_RATED -> topRatedPage == 1
            SortBy.REVENUE -> revenuePage == 1
        }
        return false
    }

    fun fetchPopular() {
        popularMovies.value = Resource.loading(null)
        popularPage = popularPage.plus(1)
        viewModelScope.launch(Dispatchers.IO) {
            val response = moviesListRepository.getMovies(popularPage, SortBy.POPULARITY)
            popularMovies.postValue(response)
        }
    }


    fun fetchTopRated() {
        popularMovies.value = Resource.loading(null)

        viewModelScope.launch {
            topRatedPage = topRatedPage.plus(1)
            viewModelScope.launch(Dispatchers.IO) {
                val response = moviesListRepository.getMovies(topRatedPage, SortBy.TOP_RATED)
                topRated.postValue(response)
            }
        }
    }

    fun fetchRevenue() {
        popularMovies.value = Resource.loading(null)

        viewModelScope.launch {
            revenuePage = revenuePage.plus(1)
            viewModelScope.launch(Dispatchers.IO) {
                val response = moviesListRepository.getMovies(revenuePage, SortBy.REVENUE)
                topRevenue.postValue(response)
            }
        }
    }
}