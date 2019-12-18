package com.tamimi.movies.model

/**
 * Created by omaraltamimi on 16,December,2019
 */
enum class SortBy(val id: Int, val sortName: String) {
    POPULARITY(1, "popularity.desc"),
    TOP_RATED(2, "vote_average.desc"),
    REVENUE(3, "revenue.desc")
}