package com.tamimi.movies.repository

import com.tamimi.movies.api.MoviesService
import com.tamimi.movies.db.MovieDao
import com.tamimi.movies.db.ReviewsDao
import com.tamimi.movies.db.VideosDao

/**
 * Created by omaraltamimi on 17,December,2019
 */
class MovieDetailsRepository(
    moviesService: MoviesService,
    movieDao: MovieDao,
    reviewsDao: ReviewsDao,
    videosDao: VideosDao
) {
}