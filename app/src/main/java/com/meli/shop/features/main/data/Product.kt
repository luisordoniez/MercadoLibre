package com.meli.shop.features.main.data

data class Product(
    val accepts_mercadopago: Boolean = false,
//    val address: Address,
//    val attributes: List<Attribute>,
    val available_quantity: Int = 1,
    val buying_mode: String = "",
    val catalog_listing: Boolean = false,
    val catalog_product_id: String = "",
    val category_id: String = "",
    val condition: String = "new",
    val currency_id: String = "",
//    val differential_pricing: DifferentialPricing,
    val domain_id: String = "",
    val id: String = "",
//    val installments: Installments,
    val listing_type_id: String = "",
//    val offer_score: Any,
//    val offer_share: Any,
//    val official_store_id: Any,
    val order_backend: Int = 1,
//    val original_price: Any,
    val permalink: String = "",
    val price: Double = 1000000.0,
//    val prices: Prices,
//    val sale_price: Any,
//    val seller: Seller,
//    val seller_address: SellerAddress,
//    val shipping: Shipping,
    val site_id: String ="",
    val sold_quantity: Int = 0,
    val stop_time: String = "",
    val tags: List<String> = listOf(),
    val thumbnail: String = "http://http2.mlstatic.com/D_943564-MLA43461425977_092020-O.jpg",
    val thumbnail_id: String = "",
    val title: String = "Motorola G6 Play Bueno Dorado Liberado",
    val use_thumbnail_id: Boolean = false
)