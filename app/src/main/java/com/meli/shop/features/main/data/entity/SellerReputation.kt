package com.meli.shop.features.main.data.entity

data class SellerReputation(
    val level_id: String,
    val metrics: Metrics,
    val power_seller_status: String,
    val protection_end_date: String,
    val real_level: String,
    val transactions: Transactions
)