package com.meli.shop.features.main.data.entity

data class Transactions(
    val canceled: Int,
    val completed: Int,
    val period: String,
    val ratings: Ratings,
    val total: Int
)