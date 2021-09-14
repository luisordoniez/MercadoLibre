package com.meli.shop.features.main.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.meli.shop.data.api.ServiceProducts
import com.meli.shop.data.db.AppDatabase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers
import org.mockito.Mockito

/**
 * Created by Luis Ordoñez on 13/09/2021.
 */

@RunWith(JUnit4::class)
class MainRepositoryTest{
    private lateinit var repository: MainRepository
    private val dao = Mockito.mock(ProductDao::class.java)
    private val service = Mockito.mock(ServiceProducts::class.java)
    private val remoteDataSource = MainDataSource(service)
    private val value = "casas"

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun init() {
        val db = Mockito.mock(AppDatabase::class.java)
        Mockito.`when`(db.productsDao()).thenReturn(dao)
        Mockito.`when`(db.runInTransaction(ArgumentMatchers.any())).thenCallRealMethod()
        repository = MainRepository(dao, remoteDataSource)
    }

    @Test
    fun getCounters() {
        runBlocking {
            repository.getProducts(value)

            Mockito.verify(dao, Mockito.never()).getProducts(value)
            Mockito.verifyZeroInteractions(dao)
        }
    }

    @Test
    fun getCountersFilter() {
        runBlocking {
            repository.getProducts(value)

            Mockito.verify(dao, Mockito.never()).getProducts(value)
            Mockito.verifyZeroInteractions(dao)
        }
    }
}