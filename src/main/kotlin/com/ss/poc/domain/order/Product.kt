package com.ss.poc.domain.order

data class Product(
    val productId: Int,
    val productName: String,
    val price: Int,
    val quantity: Int
) {
    init {
        if (price < 0) {
            throw RuntimeException("priceは自然数である必要があります")
        }
    }
}
