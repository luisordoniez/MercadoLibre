package com.meli.shop.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import kotlinx.coroutines.Dispatchers

/**
 * Created by Luis Ordoñez on 11/09/2021.
 */

fun <T> resultLiveData(networkCall: suspend () -> Result<T>): LiveData<Result<T>> = liveData(
    Dispatchers.IO) {
    emit(Result.loading<T>())
    val responseStatus = networkCall.invoke()
    if (responseStatus.status == Result.Status.SUCCESS) {
        val resultResponse = responseStatus.data
        val live : LiveData<T> = MutableLiveData(resultResponse)
        val map = live.map { Result.success(it) }
        emitSource(map)
    } else if (responseStatus.status == Result.Status.ERROR) {
        emit(Result.error<T>(responseStatus.message!!))
    }
}

fun <T, A> resultLiveData(databaseQuery: () -> LiveData<T>, networkCall: suspend () -> Result<A>, saveCallResult: suspend (A) -> Unit):
        LiveData<Result<T>> =
    liveData(Dispatchers.IO) {
        emit(Result.loading<T>())
        val source = databaseQuery.invoke().map { Result.success(it) }

        val responseStatus = networkCall.invoke()
        if (responseStatus.status == Result.Status.SUCCESS) {
            saveCallResult(responseStatus.data!! )
        } else if (responseStatus.status == Result.Status.ERROR) {
            emit(Result.error<T>(responseStatus.message!!))
        }
        emitSource(source)
    }