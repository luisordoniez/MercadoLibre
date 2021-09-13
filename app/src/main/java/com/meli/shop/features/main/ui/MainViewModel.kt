package com.meli.shop.features.main.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.meli.shop.data.Result
import com.meli.shop.features.main.data.MainRepository
import com.meli.shop.features.main.data.entity.Product
import javax.inject.Inject

class MainViewModel @Inject constructor(private var mMainRepository: MainRepository): ViewModel() {
    val products = MutableLiveData<List<Product>>()

    init {
        products.value = listOf()
    }
    fun getProducts(value : String): LiveData<Result<List<Product>>> {
        return mMainRepository.getProducts(value)
    }
}