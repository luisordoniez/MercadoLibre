package com.meli.shop.features.main.data.entity

data class Prices(
    val id: String,
    val payment_method_prices: List<Any>,
    val presentation: Presentation,
    val prices: List<Price>,
    val purchase_discounts: List<Any>,
    val reference_prices: List<Any>
)