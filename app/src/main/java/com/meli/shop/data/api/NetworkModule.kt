package com.meli.shop.data.api

import com.facebook.stetho.okhttp3.BuildConfig
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.meli.shop.features.main.data.MainDataSource
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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
    fun provideProductsService(@ProductsAPI okHttpClient: OkHttpClient, converterFactory: GsonConverterFactory) =
        provideService(okHttpClient, converterFactory, ServiceProducts::class.java)

    @Singleton
    @Provides
    fun provideMainDataSource(service: ServiceProducts)= MainDataSource(service)

    @ProductsAPI
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

    @Provides
    fun provideLoggingInterceptor() = HttpLoggingInterceptor().apply { level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE }

    @Provides
    fun provideOkHttpClient(logIn: HttpLoggingInterceptor, token: TokenInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(logIn)
            .addInterceptor(token)
            .addNetworkInterceptor(StethoInterceptor())
            .build()

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Provides
    @Singleton
    fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory = GsonConverterFactory.create(gson)
}