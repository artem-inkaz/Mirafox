package ui.smartpro.mirafox.repository.ordersinteractor

import ui.smartpro.mirafox.data.Orders
import ui.smartpro.mirafox.data.OrdersDto

interface OrdersInteractor {
    suspend fun getOrders(ordersDto: List<OrdersDto>): List<Orders>
}