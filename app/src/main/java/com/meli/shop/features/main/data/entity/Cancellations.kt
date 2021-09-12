package com.meli.shop.features.main.data.entity

data class Cancellations(
    val excluded: Excluded,
    val period: String,
    val rate: Double,
    val value: Int
)