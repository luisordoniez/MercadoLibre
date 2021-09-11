package com.meli.shop.api

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Luis Ordoñez on 11/09/2021.
 */

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideProductsService(okHttpClient: OkHttpClient, converterFactory: GsonConverterFactory) =
        provideService(okHttpClient, converterFactory, ServiceProducts::class.java)

    @Provides
    fun providePrivateOkHttpClient(upstreamClient: OkHttpClient): OkHttpClient {
        return upstreamClient.newBuilder().build()
    }

    private fun <T> provideService(okHttpClient: OkHttpClient, converterFactory: GsonConverterFactory, clazz: Class<T>): T {
        return createRetrofit(okHttpClient, converterFactory).create(clazz)
    }

    private fun createRetrofit(okHttpClient: OkHttpClient, converterFactory: GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Endpoints.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()
    }
}