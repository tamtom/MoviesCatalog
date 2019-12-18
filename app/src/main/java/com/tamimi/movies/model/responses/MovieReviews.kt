package com.tamimi.movies.model.responses

import com.google.gson.annotations.SerializedName
import com.tamimi.movies.model.Review

class MovieReviews(@SerializedName("results") var reviews: ArrayList<Review>)