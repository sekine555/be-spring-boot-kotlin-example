package com.ss.poc.application.order

interface IOrderService {
    fun updateOrderProduct(command: OrderProductUpdateCommand)
}
