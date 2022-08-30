package com.ss.poc.infrastucture.order

import org.springframework.data.mongodb.core.mapping.Document

@Document("order")
data class OrderEntity(
    val orderId: String,
    val orderDate: String,
    val userId: Int,
    val userName: String,
    val orderDetails: List<OrderDetailEntity>
)
