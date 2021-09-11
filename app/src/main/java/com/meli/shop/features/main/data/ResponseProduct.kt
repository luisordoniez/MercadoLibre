package com.meli.shop.features.main.data

data class ResponseProduct(
    val available_filters: List<AvailableFilter>,
    val available_sorts: List<AvailableSort>,
    val country_default_time_zone: String,
    val filters: List<Filter>,
    val paging: Paging,
    val query: String,
    val results: List<Product>,
    val site_id: String,
    val sort: Sort
)