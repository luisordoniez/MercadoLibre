package com.meli.shop.features.main.data

data class Cancellations(
    val excluded: Excluded,
    val period: String,
    val rate: Double,
    val value: Int
)