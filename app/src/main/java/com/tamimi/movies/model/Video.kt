package com.tamimi.movies.model

import androidx.room.Entity

/**
 * Created by omaraltamimi on 16,December,2019
 */
@Entity(primaryKeys = [("id")])
class Video(
    var id: Int,
    var key: String? = null,
    var size: Int = 0,
    var type: String? = null,
    var movieId: Long = 0
)