package ui.smartpro.mirafox.ui.orders

import ui.smartpro.mirafox.data.Orders

sealed class OrdersAppState {
    data class Success(
        val ordersData: List<Orders>
    ) : OrdersAppState()

    data class Error(val error: Throwable) : OrdersAppState()
    object Loading : OrdersAppState()

}