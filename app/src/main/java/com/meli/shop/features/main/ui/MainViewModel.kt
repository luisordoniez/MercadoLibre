package com.meli.shop.features.main.ui

import androidx.lifecycle.ViewModel
import com.meli.shop.features.main.data.MainRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(private var mMainRepository: MainRepository): ViewModel() {
    fun getProducts(value : String) = mMainRepository.getProducts(value)
}