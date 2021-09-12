package com.meli.shop.features.main.data.entity

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("accepts_mercadopago")
    val acceptsMercadoPago: Boolean = false,
//    @SerializedName("address")
//    val address: Address,
//    @SerializedName("attributes")
//    val attributes: List<Attribute>,
    @SerializedName("available_quantity")
    val availableQuantity: Int = 1,
    @SerializedName("buying_mode")
    val buyingMode: String = "",
    @SerializedName("catalog_listing")
    val catalogListing: Boolean = false,
    @SerializedName("catalog_product_id")
    val catalogProductId: String = "",
    @SerializedName("category_id")
    val categoryId: String = "",
    @SerializedName("condition")
    val condition: String = "new",
    @SerializedName("currency_id")
    val currencyId: String = "",
//    @SerializedName("differential_pricing")
//    val differentialPricing: DifferentialPricing,
    @SerializedName("domain_id")
    val domainId: String = "",
    @SerializedName("id")
    val id: String = "",
//    @SerializedName("installments")
//    val installments: Installments,
    @SerializedName("listing_type_id")
    val listingTypeId: String = "",
//    @SerializedName("offer_score")
//    val offerScore: Any,
//    @SerializedName("offer_share")
//    val offerShare: Any,
//    @SerializedName("official_store_id")
//    val officialStore_id: Any,
    @SerializedName("order_backend")
    val orderBackend: Int = 1,
//    @SerializedName("original_price")
//    val originalPrice: Any,
    @SerializedName("permalink")
    val permalink: String = "",
    @SerializedName("price")
    val price: Double = 1000000.0,
//    @SerializedName("prices")
//    val prices: Prices,
//    @SerializedName("sale_price")
//    val salePrice: Any,
//    @SerializedName("seller")
//    val seller: Seller,
//    @SerializedName("seller_address")
//    val sellerAddress: SellerAddress,
//    @SerializedName("shipping")
//    val shipping: Shipping,
    @SerializedName("site_id")
    val siteId: String ="",
    @SerializedName("sold_quantity")
    val soldQuantity: Int = 0,
    @SerializedName("stop_time")
    val stopTime: String = "",
    @SerializedName("tags")
    val tags: List<String> = listOf(),
    @SerializedName("thumbnail")
    val thumbnail: String = "http://http2.mlstatic.com/D_943564-MLA43461425977_092020-O.jpg",
    @SerializedName("thumbnail_id")
    val thumbnailId: String = "",
    @SerializedName("title")
    val title: String = "Motorola G6 Play Bueno Dorado Liberado",
    @SerializedName("use_thumbnail_id")
    val useThumbnailId: Boolean = false
)