package com.ss.poc.application.order.impl

import com.ss.poc.application.order.IOrderService
import com.ss.poc.application.order.OrderProductUpdateCommand
import com.ss.poc.application.order.ProductDto
import com.ss.poc.domain.order.IOrderCustomRepository
import com.ss.poc.domain.order.Product
import org.springframework.stereotype.Service

@Service
class OrderService(private val orderCustomRepository: IOrderCustomRepository) : IOrderService {
    override fun updateOrderProduct(command: OrderProductUpdateCommand) {
        // 該当の注文データ存在有無確認
        val orderCount =
            orderCustomRepository.fetchCountOrderByOrderIdAndUserId(
                command.orderId,
                command.userId,
                command.orderDetailId
            )
        // データなし or 2件以上存在する場合にはシステム異常としてスローさせる
        if (orderCount != 1L) {
            throw RuntimeException("対象データが存在しないか2件以上存在します >>> orderId: ${command.orderId} / userId: ${command.userId} / orderDetailId: ${command.orderDetailId}")
        }

        // Productドメイン生成
        val product = Product(command.productId, command.productName, command.price, command.quantity)

        // 注文商品を追加する（追加されたかどうかを検証する必要あり）
        val updateResult = orderCustomRepository.updateOrderProductByOrderIdAndUserId(
            command.orderId,
            command.userId,
            command.orderDetailId,
            ProductDto(product)
        )
        if (!updateResult) {
            throw RuntimeException("追加に失敗しました >>> orderId: ${command.orderId} / userId: ${command.userId} / orderDetailId: ${command.orderDetailId}")
        }
    }
}
