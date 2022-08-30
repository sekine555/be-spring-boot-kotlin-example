package com.ss.poc.infrastucture.order

data class OrderDetailEntity(
    val orderDetailId: String,
    val products: List<ProductEntity>
)
