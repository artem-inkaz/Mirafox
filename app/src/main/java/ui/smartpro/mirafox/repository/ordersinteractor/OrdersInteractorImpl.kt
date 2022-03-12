package ui.smartpro.mirafox.repository.ordersinteractor

import android.os.Build
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ui.smartpro.mirafox.data.Orders
import ui.smartpro.mirafox.data.OrdersDto
import ui.smartpro.mirafox.utils.*
import java.time.LocalDateTime

class OrdersInteractorImpl : OrdersInteractor {
    override suspend fun getOrders(ordersDto: List<OrdersDto>): List<Orders> =
        withContext(Dispatchers.IO) {
            ordersDto.map { ordersDto: OrdersDto ->
                Orders(
                    name = ordersDto.name,
                    image = ordersDto.image,
                    data = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        ordersDto.data?.let { dateConverter(it) }?.let {
                            getDuration(
                                it,
                                LocalDateTime.now()
                            )
                        }
                    } else {
                        ordersDto.data?.let { dateConverterApi(it) }?.let {
                            getDurationApi(
                                it,
                                asLocalDate()
                            )
                        }
                    },
                    time = ordersDto.time,
                    description = ordersDto.description,
                    status = ordersDto.status?.status.toString(),
                    price = ordersDto.price,
                )
            }
        }
}