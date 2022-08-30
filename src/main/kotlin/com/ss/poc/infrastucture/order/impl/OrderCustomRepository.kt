package com.ss.poc.infrastucture.order.impl

import com.ss.poc.application.order.ProductDto
import com.ss.poc.domain.order.IOrderCustomRepository
import com.ss.poc.infrastucture.order.OrderEntity
import com.ss.poc.infrastucture.order.ProductEntity
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Repository

@Repository
class OrderCustomRepository(private val mongoTemplate: MongoTemplate) : IOrderCustomRepository {
    override fun fetchCountOrderByOrderIdAndUserId(orderId: String, userId: Int, orderDetailId: String): Long {
        val query = buildQuery(orderId, userId, orderDetailId)
        return mongoTemplate.count(query, OrderEntity::class.java)
    }

    override fun updateOrderProductByOrderIdAndUserId(
        orderId: String,
        userId: Int,
        orderDetailId: String,
        productDto: ProductDto
    ): Boolean {
        val query = buildQuery(orderId, userId, orderDetailId)
        val update = Update().push("orderDetails.$[element].products", ProductEntity(productDto))
            .filterArray(Criteria.where("element.orderDetailId").`is`(orderDetailId))
        val updateResult = mongoTemplate.updateFirst(query, update, OrderEntity::class.java)
        return updateResult.modifiedCount > 0
    }

    private fun buildQuery(orderId: String, userId: Int, orderDetailId: String): Query {
        val query = Query.query(Criteria.where("orderDetails.orderDetailId").`is`(orderDetailId))
        query.addCriteria(Criteria.where("orderId").`is`(orderId).and("userId").`is`(userId))
        return query
    }
}
