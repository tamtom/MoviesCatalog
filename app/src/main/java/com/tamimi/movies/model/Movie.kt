package com.tamimi.movies.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

/**
 * Created by omaraltamimi on 16,December,2019
 */
@Entity(primaryKeys = [("movieId")])
class Movie(
    @SerializedName("original_title") var title: String? = null,
    @SerializedName("release_date") var releaseDate: String? = null,
    @SerializedName("poster_path") var posterUrl: String? = null,
    @SerializedName("vote_average") var rating: Float = 0f,
    var overview: String? = null,
    @SerializedName("backdrop_path") var backDropUrl: String? = null,
    @SerializedName("runtime") var duration: Int = 0,
    @SerializedName("vote_count") var voteCount: Int = 0,
    @SerializedName("id") var movieId: Long = 0
)