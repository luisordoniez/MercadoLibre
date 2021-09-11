package com.meli.shop.api

import com.meli.shop.features.main.data.ResponseProduct
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Luis Ordoñez on 11/09/2021.
 */

interface ServiceProducts {
    @GET(Endpoints.SEARCH)
    fun getProducts(value : String): Response<ResponseProduct>
}