package com.tamimi.movies.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

/**
 * Created by omaraltamimi on 17,December,2019
 */
data class TypeWithMovies(
    @Embedded val type: Type,
    @Relation(
        parentColumn = "typeId",
        entityColumn = "movieId",
        associateBy = Junction(MoviesTypeRef::class)
    )
    val movies: List<Movie>
)