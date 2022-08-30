package com.ss.poc.domain.order

import com.ss.poc.application.order.ProductDto

interface IOrderCustomRepository {
    fun fetchCountOrderByOrderIdAndUserId(orderId: String, userId: Int, orderDetailId: String): Int
    fun updateOrderProductByOrderIdAndUserId(
        orderId: String,
        userId: Int,
        orderDetailId: String,
        productDto: ProductDto
    ): Boolean
}
