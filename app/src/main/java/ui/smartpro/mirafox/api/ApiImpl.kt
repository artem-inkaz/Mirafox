package ui.smartpro.mirafox.api

import ui.smartpro.mirafox.data.OrdersDto
import ui.smartpro.mirafox.data.getListOrders

class ApiImpl : Api {
    override fun getOrdersDto(): List<OrdersDto> = getListOrders()
}