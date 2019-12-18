package com.tamimi.movies.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.tamimi.movies.api.MoviesService
import com.tamimi.movies.model.Movie
import com.tamimi.movies.model.MoviesTypeRef

/**
 * Created by omaraltamimi on 17,December,2019
 */
@Dao
interface MoviesAndTypeDao {
    @Transaction
    @Query(
        """SELECT * FROM MOVIE   INNER JOIN MoviesTypeRef on 
        MOVIE.movieId = MoviesTypeRef.movieId where MoviesTypeRef.typeId = :type_ ORDER BY MoviesTypeRef.id limit :from,${MoviesService.PAGE_SIZE} """
    )
    suspend fun getMovieOfType(type_: Int, from: Int): List<Movie>

    @Insert
    suspend fun insertMovieWithType(item: MoviesTypeRef)
}