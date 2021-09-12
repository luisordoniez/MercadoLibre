package com.meli.shop.features.main.data.entity

data class Metrics(
    val cancellations: Cancellations,
    val claims: Claims,
    val delayed_handling_time: DelayedHandlingTime,
    val sales: Sales
)