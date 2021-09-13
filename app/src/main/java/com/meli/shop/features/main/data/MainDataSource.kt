package com.meli.shop.features.main.data

import com.meli.shop.data.api.BaseDataSource
import com.meli.shop.data.api.ServiceProducts
import javax.inject.Inject

/**
 * Created by Luis Ordoñez on 11/09/2021.
 */

class MainDataSource @Inject constructor(private val service: ServiceProducts) : BaseDataSource() {
    suspend fun getProducts(value : String) = getResult { service.getProducts(value) }
}