package com.meli.shop.features.main.data.entity

data class Filter(
    val id: String,
    val name: String,
    val type: String,
    val values: List<ValueX>
)