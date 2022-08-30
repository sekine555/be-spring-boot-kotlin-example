package com.ss.poc.presentation.order

import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive
import javax.validation.constraints.PositiveOrZero

data class UpdateOrderProductRequest(
    @field: NotNull val orderId: String,
    @field: Positive val userId: Int,
    @field: NotNull val orderDetailId: String,
    @field: Positive val productId: Int,
    @field: NotNull val productName: String,
    @field: PositiveOrZero val price: Int,
    @field: NotNull val quantity: Int
)
