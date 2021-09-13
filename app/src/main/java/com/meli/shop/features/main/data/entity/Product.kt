package com.meli.shop.features.main.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "product")
data class Product(
    @field:SerializedName("accepts_mercadopago")
    val acceptsMercadoPago: Boolean?,
//    @field:SerializedName("address")
//    val address: Address?,
//    @field:SerializedName("attributes")
//    val attributes: List<Attribute>?,
    @field:SerializedName("available_quantity")
    val availableQuantity: Int?,
    @field:SerializedName("buying_mode")
    val buyingMode: String?,
    @field:SerializedName("catalog_listing")
    val catalogListing: Boolean?,
    @field:SerializedName("catalog_product_id")
    val catalogProductId: String?,
    @field:SerializedName("category_id")
    val categoryId: String?,
    @field:SerializedName("condition")
    val condition: String?,
    @field:SerializedName("currency_id")
    val currencyId: String?,
//    @field:SerializedName("differential_pricing")
//    val differentialPricing: DifferentialPricing?,
    @field:SerializedName("domain_id")
    val domainId: String?,
    @PrimaryKey
    @field:SerializedName("id")
    val id: String,
//    @field:SerializedName("installments")
//    val installments: Installments?,
    @field:SerializedName("listing_type_id")
    val listingTypeId: String?,
//    @field:SerializedName("offer_score")
//    val offerScore: Any?,
//    @field:SerializedName("offer_share")
//    val offerShare: Any?,
//    @field:SerializedName("official_store_id")
//    val officialStore_id: Any?,
    @field:SerializedName("order_backend")
    val orderBackend: Int?,
//    @field:SerializedName("original_price")
//    val originalPrice: Any?,
    @field:SerializedName("permalink")
    val permalink: String?,
    @field:SerializedName("price")
    val price: Double?,
//    @field:SerializedName("prices")
//    val prices: Prices?,
//    @field:SerializedName("sale_price")
//    val salePrice: Any?,
//    @field:SerializedName("seller")
//    val seller: Seller?,
//    @field:SerializedName("seller_address")
//    val sellerAddress: SellerAddress?,
//    @field:SerializedName("shipping")
//    val shipping: Shipping?,
    @field:SerializedName("site_id")
    val siteId: String?,
    @field:SerializedName("sold_quantity")
    val soldQuantity: Int?,
    @field:SerializedName("stop_time")
    val stopTime: String?,
//    @field:SerializedName("tags")
//    val tags: List<String>?,
    @field:SerializedName("thumbnail")
    val thumbnail: String?,
    @field:SerializedName("thumbnail_id")
    val thumbnailId: String?,
    @field:SerializedName("title")
    val title: String?,
    @field:SerializedName("use_thumbnail_id")
    val useThumbnailId: Boolean?
): Serializable