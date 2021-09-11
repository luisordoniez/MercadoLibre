package com.meli.shop.features.main.data

data class AvailableFilter(
    val id: String,
    val name: String,
    val type: String,
    val values: List<Value>
)