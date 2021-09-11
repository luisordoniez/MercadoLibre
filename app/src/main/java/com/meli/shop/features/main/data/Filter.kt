package com.meli.shop.features.main.data

data class Filter(
    val id: String,
    val name: String,
    val type: String,
    val values: List<ValueX>
)