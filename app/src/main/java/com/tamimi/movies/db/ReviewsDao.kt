package com.tamimi.movies.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tamimi.movies.model.Review

/**
 * Created by omaraltamimi on 17,December,2019
 */
@Dao
interface ReviewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReviewList(reviews: List<Review>)

    @Query("SELECT * FROM Review WHERE movieId = :id_")
    suspend fun getReviews(id_: Int): List<Review>
}