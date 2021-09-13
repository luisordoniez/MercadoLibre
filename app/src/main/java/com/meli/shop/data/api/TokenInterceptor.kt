package com.meli.shop.data.api

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Luis Ordoñez on 11/09/2021.
 */

@Singleton
class TokenInterceptor @Inject constructor() : Interceptor {
    var token:String=""
    override fun intercept(chain: Interceptor.Chain): Response {

        val original = chain.request()

        if (token.isEmpty()) {
            return  chain.proceed(original)
        }

        val originalHttpUrl = original.url
        val requestBuilder = original.newBuilder().addHeader("Authorization",token).url(originalHttpUrl)

        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}