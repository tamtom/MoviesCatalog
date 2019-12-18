package com.tamimi.movies.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.tamimi.movies.model.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

/**
 * Created by omaraltamimi on 17,December,2019
 */
abstract class NetworkBoundResource<ResultType, RequestType>() {

    private val resourceResult = MediatorLiveData<Resource<ResultType>>()
    var dataSource: ResultType? = null

    init {
        CoroutineScope(Dispatchers.Main).launch {
            resourceResult.value = Resource.loading(null)
        }
        CoroutineScope(Dispatchers.IO).launch {
            val dbSource = loadFromDb()
            dataSource = dbSource
            if (shouldFetchFromNetwork(dbSource)) {
                fetchFromNetwork(dbSource)
            } else {
                setValue(Resource.success(dbSource))
            }
        }
    }

    private suspend fun fetchFromNetwork(dbSource: ResultType) {
        try {
            val response = createCall()
            setValue(Resource.loading(dbSource))
            if (response.isSuccessful) {
                if (response.body() != null) {
                    saveCallResult(response.body())
                    setValue(Resource.success(loadFromDb()))
                } else {
                    setValue(
                        Resource.error(
                            loadFromDb(),
                            "error"
                        )
                    )
                }
            } else {
                onFetchFailed()
                setValue(Resource.error(dbSource, response.message()))
            }
        } catch (ex: Exception) {
            onFetchFailed()
            setValue(Resource.error(dbSource, ex.message))
        }
    }

    private fun setValue(newValue: Resource<ResultType>) {
        CoroutineScope(Dispatchers.Main).launch {
            if (resourceResult != null)
                resourceResult.value = newValue
        }
    }

    protected abstract suspend fun loadFromDb(): ResultType

    protected abstract suspend fun shouldFetchFromNetwork(data: ResultType?): Boolean

    protected abstract suspend fun createCall(): Response<RequestType>

    protected abstract suspend fun saveCallResult(data: RequestType?)

    fun asLiveData() = resourceResult as LiveData<Resource<ResultType>>

    protected open fun onFetchFailed() {}
}