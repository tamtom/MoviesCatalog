package com.tamimi.movies.api

import com.tamimi.movies.model.responses.MovieReviews
import com.tamimi.movies.model.responses.MovieVideos
import com.tamimi.movies.model.responses.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by omaraltamimi on 16,December,2019
 */
interface MoviesService {
    @GET("discover/movie")
    suspend fun fetchMovies(
        @Query("page") page: Int,
        @Query("sort_by") sortBy: String?
    ): Response<MoviesResponse>

    @GET("movie/{id}/videos")
    suspend fun getMovieVideos(@Path("id") id: Long): Response<MovieVideos>

    @GET("movie/{id}/reviews")
    suspend fun getMovieReviews(@Path("id") id: Long): Response<MovieReviews>

    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val API_KEY = "" //Your api key here
        const val PAGE_SIZE = 20
    }
}
