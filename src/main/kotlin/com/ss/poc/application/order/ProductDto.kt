package com.ss.poc.application.order

import com.ss.poc.domain.order.Product

data class ProductDto(
    val productId: Int,
    val productName: String,
    val price: Int,
    val quantity: Int
) {
    constructor(product: Product) : this(
        product.productId,
        product.productName,
        product.price,
        product.quantity
    )
}
