package com.ss.poc.infrastucture.order

import com.ss.poc.application.order.ProductDto

data class ProductEntity(
    val productId: Int,
    val productName: String,
    val price: Int,
    val quantity: Int
) {
    constructor(productDto: ProductDto) : this(
        productDto.productId,
        productDto.productName,
        productDto.price,
        productDto.quantity
    )
}
