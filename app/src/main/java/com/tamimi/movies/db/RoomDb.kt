package com.tamimi.movies.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tamimi.movies.model.*

/**
 * Created by omaraltamimi on 17,December,2019
 */
@Database(
    entities = [(Movie::class), (Review::class), (Video::class), (Type::class), (MoviesTypeRef::class)],
    version = 1,
    exportSchema = false
)
abstract class RoomDb : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun reviewDao(): ReviewsDao
    abstract fun videoDao(): VideosDao
    abstract fun movieTypeDao(): MoviesAndTypeDao
    abstract fun typeDao(): TypeDao

    companion object {
        const val DATABASE_NAME = "movies.db"
    }
}