package com.tamimi.movies.model

import androidx.room.Entity

/**
 * Created by omaraltamimi on 16,December,2019
 */
@Entity(primaryKeys = [("id")])
class Review(
    var id: Int,
    var author: String? = null,
    var content: String? = null,
    var movieId: Long = 0
)