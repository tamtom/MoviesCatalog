package com.tamimi.movies.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by omaraltamimi on 17,December,2019
 */
@Entity
data class MoviesTypeRef(
    val typeId: Int,
    val movieId: Long,
    @PrimaryKey(autoGenerate = true) val id: Long =0
)