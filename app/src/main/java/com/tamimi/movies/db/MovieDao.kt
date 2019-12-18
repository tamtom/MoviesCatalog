package com.tamimi.movies.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tamimi.movies.model.Movie

/**
 * Created by omaraltamimi on 17,December,2019
 */
@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieList(movies: List<Movie>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movies: Movie)

    @Query("SELECT * FROM MOVIE WHERE movieId = :id_")
    suspend fun getMovie(id_: Int): Movie
}