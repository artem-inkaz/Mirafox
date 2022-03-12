package ui.smartpro.mirafox.api

import ui.smartpro.mirafox.data.OrdersDto

interface Api {
    fun getOrdersDto(): List<OrdersDto>
}