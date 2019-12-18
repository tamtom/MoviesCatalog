package com.tamimi.movies.model.responses

import com.google.gson.annotations.SerializedName
import com.tamimi.movies.model.Video

/**
 * Created by omaraltamimi on 16,December,2019
 */
class MovieVideos(@SerializedName("results") val videos: ArrayList<Video>)