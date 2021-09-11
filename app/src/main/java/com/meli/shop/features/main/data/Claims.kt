package com.meli.shop.features.main.data

data class Claims(
    val excluded: ExcludedX,
    val period: String,
    val rate: Double,
    val value: Int
)