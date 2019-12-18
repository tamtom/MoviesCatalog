package com.tamimi.movies.model.responses

import com.google.gson.annotations.SerializedName
import com.tamimi.movies.model.Movie

/**
 * Created by omaraltamimi on 16,December,2019
 */
data class MoviesResponse(
    val success: Int? = null,
    @SerializedName("status_code") val status_code: Int? = null,
    @SerializedName("status_message") val status_message: String? = null,
    val page: Int? = null,
    @SerializedName("results") val movies: List<Movie>,
    @SerializedName("total_pages") val total_pages: Int? = null,
    @SerializedName("total_results") val total_results: Int? = null
)