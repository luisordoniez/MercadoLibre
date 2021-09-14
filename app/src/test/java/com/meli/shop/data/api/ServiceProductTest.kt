package com.meli.shop.data.api

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.hamcrest.CoreMatchers
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Luis Ordoñez on 13/09/2021.
 */

@RunWith(JUnit4::class)
class ServiceProductTest{

    private val value = "casas"

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var service: ServiceProducts

    private lateinit var mockWebServer: MockWebServer

    @Before
    fun createService() {
        mockWebServer = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(mockWebServer.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ServiceProducts::class.java)
    }

    @After
    fun stopService() {
        mockWebServer.shutdown()
    }

    @Test
    fun requestGetProducts() {
        runBlocking {
            enqueueResponse("products.json")
            val resultResponse = service.getProducts(value).body()

            val request = mockWebServer.takeRequest()
            Assert.assertNotNull(resultResponse)
            Assert.assertThat(request.path, CoreMatchers.`is`("/${Endpoints.SEARCH}?q=$value"))
        }
    }

    @Test
    fun responseGetProducts() {
        runBlocking {
            enqueueResponse("products.json")
            val resultResponse = service.getProducts(value)
            val products = resultResponse.body()
            Assert.assertThat(products?.results?.size, CoreMatchers.`is`(50))
        }
    }

    private fun enqueueResponse(fileName: String, headers: Map<String, String> = emptyMap()) {
        val inputStream = javaClass.classLoader!!.getResourceAsStream("api-response/$fileName")
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        for ((key, value) in headers) {
            mockResponse.addHeader(key, value)
        }
        mockWebServer.enqueue(mockResponse.setBody(
            source.readString(Charsets.UTF_8))
        )
    }
}