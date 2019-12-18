package com.tamimi.movies.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tamimi.movies.model.Video

/**
 * Created by omaraltamimi on 17,December,2019
 */
@Dao
interface VideosDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVideosList(videos: List<Video>)

    @Query("SELECT * FROM Video WHERE movieId = :id_")
    suspend fun getVideos(id_: Int): List<Video>
}