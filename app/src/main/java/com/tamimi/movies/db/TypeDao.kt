package com.tamimi.movies.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.tamimi.movies.model.Type

/**
 * Created by omaraltamimi on 18,December,2019
 */

@Dao
interface TypeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertType(type: Type)
}
