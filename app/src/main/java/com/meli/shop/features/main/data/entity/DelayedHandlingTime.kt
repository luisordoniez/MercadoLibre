package com.meli.shop.features.main.data.entity

data class DelayedHandlingTime(
    val excluded: ExcludedXX,
    val period: String,
    val rate: Double,
    val value: Int
)