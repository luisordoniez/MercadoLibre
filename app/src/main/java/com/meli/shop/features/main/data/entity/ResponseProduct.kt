package com.meli.shop.features.main.data.entity

import com.google.gson.annotations.SerializedName

data class ResponseProduct(
    @SerializedName("available_filters")
    val availableFilters: List<AvailableFilter>,
    @SerializedName("available_sorts")
    val availableSorts: List<AvailableSort>,
    @SerializedName("country_default_time_zone")
    val countryDefaultTimeZone: String,
    @SerializedName("filters")
    val filters: List<Filter>,
    @SerializedName("paging")
    val paging: Paging,
    @SerializedName("query")
    val query: String,
    @SerializedName("results")
    val results: List<Product>,
    @SerializedName("site_id")
    val siteId: String,
    @SerializedName("sort")
    val sort: Sort
)