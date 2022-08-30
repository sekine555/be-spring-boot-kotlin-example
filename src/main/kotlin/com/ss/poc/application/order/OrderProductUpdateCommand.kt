package com.ss.poc.application.order

data class OrderProductUpdateCommand(
    val orderId: String,
    val userId: Int,
    val orderDetailId: String,
    val productId: Int,
    val productName: String,
    val price: Int,
    val quantity: Int
)
