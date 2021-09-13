package com.meli.shop.features.main.data

import com.meli.shop.data.resultLiveData
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Luis Ordoñez on 11/09/2021.
 */

@Singleton
class MainRepository @Inject constructor(private val dao: ProductDao ,private val dataSource: MainDataSource) {
//    fun getProducts (value : String) = resultLiveData(networkCall = { dataSource.getProducts(value)})
    fun getProducts (value : String) = resultLiveData(
        databaseQuery = { dao.getProducts(value) },
        networkCall = { dataSource.getProducts(value) },
        saveCallResult = { dao.insertAll(it.results) }
    )
}