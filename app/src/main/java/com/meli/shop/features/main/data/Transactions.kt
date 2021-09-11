package com.meli.shop.features.main.data

data class Transactions(
    val canceled: Int,
    val completed: Int,
    val period: String,
    val ratings: Ratings,
    val total: Int
)