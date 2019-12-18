package com.tamimi.movies.repository

import com.tamimi.movies.api.MoviesService
import com.tamimi.movies.db.MovieDao
import com.tamimi.movies.db.MoviesAndTypeDao
import com.tamimi.movies.db.TypeDao
import com.tamimi.movies.model.*
import com.tamimi.movies.model.responses.MoviesResponse

/**
 * Created by omaraltamimi on 17,December,2019
 */
class MoviesListRepository(
    val moviesService: MoviesService,
    val moviesAndTypeDao: MoviesAndTypeDao,
    val movieDao: MovieDao,
    val typeDao: TypeDao
) {

    suspend fun getMovies(page: Int, sortBy: SortBy): Resource<List<Movie>> {
        val dataSource = loadFromDb(sortBy, page)
        if (dataSource.isNullOrEmpty()) {
            return createCall(page, sortBy)
        }
        return Resource.success(dataSource)
    }

    private suspend fun createCall(page: Int, sortBy: SortBy): Resource<List<Movie>> {
        try {
            val response = moviesService.fetchMovies(page, sortBy.sortName)
            return if (response.isSuccessful) {
                if (response.body() != null) {
                    saveCallResult(response.body(), sortBy)
                    val loadFromDb = loadFromDb(sortBy, page)
                    Resource.success(loadFromDb)

                } else {
                    Resource.error(
                        null,
                        "error"
                    )

                }
            } else {
                Resource.error(null, response.message())
            }
        } catch (ex: Exception) {
            return Resource.error(null, ex.message)

        }
    }

    private suspend fun loadFromDb(sortBy: SortBy, page: Int): List<Movie> = moviesAndTypeDao
        .getMovieOfType(sortBy.id, ((page - 1) * MoviesService.PAGE_SIZE))

    private suspend fun saveCallResult(data: MoviesResponse?, sortBy: SortBy) {
        data?.movies?.forEach {
            movieDao.insertMovie(it)
            moviesAndTypeDao.insertMovieWithType(
                MoviesTypeRef(
                    sortBy.id
                    , it.movieId
                )
            )
        }
    }

    suspend fun inserTypes() {
        typeDao.insertType(Type(SortBy.REVENUE.id, SortBy.REVENUE.sortName))
        typeDao.insertType(Type(SortBy.POPULARITY.id, SortBy.POPULARITY.sortName))
        typeDao.insertType(Type(SortBy.TOP_RATED.id, SortBy.TOP_RATED.sortName))
    }
}