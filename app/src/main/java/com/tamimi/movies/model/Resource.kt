package com.tamimi.movies.model

/**
 * Created by omaraltamimi on 17,December,2019
 */
data class Resource<out T>(val status: Status?, val data: T?, val message: String?) {

    enum class Status {
        LOADING,
        SUCCESS,
        ERROR
    }

    companion object {

        fun <T> loading(data: T?) = Resource(
            Status.LOADING,
            data,
            null
        )

        fun <T> success(data: T?) = Resource(
            Status.SUCCESS,
            data,
            null
        )

        fun <T> error(data: T?, message: String?) = Resource(
            Status.ERROR,
            data,
            message
        )
    }
}