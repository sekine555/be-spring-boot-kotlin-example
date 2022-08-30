package com.ss.poc.presentation.order

import com.ss.poc.application.order.IOrderService
import com.ss.poc.application.order.OrderProductUpdateCommand
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["api/v1/order"], produces = ["application/json"])
class OrderController(private val orderService: IOrderService) {
    @PutMapping("/product")
    fun updateOrderProduct(@RequestBody @Validated updateOrderProductRequest: UpdateOrderProductRequest) {
        orderService.updateOrderProduct(
            OrderProductUpdateCommand(
                updateOrderProductRequest.orderId,
                updateOrderProductRequest.userId,
                updateOrderProductRequest.orderDetailId,
                updateOrderProductRequest.productId,
                updateOrderProductRequest.productName,
                updateOrderProductRequest.price,
                updateOrderProductRequest.quantity
            )
        )
    }
}
