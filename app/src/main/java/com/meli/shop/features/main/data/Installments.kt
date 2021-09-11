package com.meli.shop.features.main.data

data class Installments(
    val amount: Double,
    val currency_id: String,
    val quantity: Int,
    val rate: Double
)