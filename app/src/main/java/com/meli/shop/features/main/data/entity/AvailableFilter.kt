package com.meli.shop.features.main.data.entity

data class AvailableFilter(
    val id: String,
    val name: String,
    val type: String,
    val values: List<Value>
)