package com.meli.shop.data.api

import com.meli.shop.features.main.data.entity.ResponseProduct
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.*

/**
 * Created by Luis Ordoñez on 11/09/2021.
 */

interface ServiceProducts {
    @GET(Endpoints.SEARCH)
    suspend fun getProducts(@Query("q") value : String): Response<ResponseProduct>
}