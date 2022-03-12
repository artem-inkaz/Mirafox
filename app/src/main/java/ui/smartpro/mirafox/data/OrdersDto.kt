package ui.smartpro.mirafox.data

import ui.smartpro.mirafox.R

data class OrdersDto(
    val name: String? = "",
    val image: Int? = 0,
    val data: String? = "",
    val time: String? = "",
    val description: String? = "",
    val status: StatusTYPE? = null,
    val price: String? = "",
) {
    enum class StatusTYPE(val status: String) {
        INWORK("В работе"),
        PROVIDEDATA("Предоставьте данные"),
        DONEWORK("Выполнено")
    }
}

fun getListOrders() = mutableListOf(
    OrdersDto(
        name = "Петров",
        image = R.drawable.choose_photo_overlay,
        data = "2022-03-11 18:10",
        time = "12:05",
        description = "Съемка с квадрокоптера всего процесса обучения",
        status = OrdersDto.StatusTYPE.INWORK,
        price = "45 500 Р"
    ),
    OrdersDto(
        name = "Vangelloff",
        image = R.drawable.choose_photo_overlay,
        data = "2022-03-11 12:10",
        time = "15:05",
        description = "Сделаю элегантный премиум логотип + визитная карточка",
        status = OrdersDto.StatusTYPE.INWORK,
        price = "155 500 Р"
    ),
    OrdersDto(
        name = "Сидоров",
        image = R.drawable.choose_photo_overlay,
        data = "2022-03-10 10:10",
        time = "10:05",
        description = "Логотип по образцу в векторе в максимальном качестве\n",
        status = OrdersDto.StatusTYPE.INWORK,
        price = "30 500 Р"
    ),
    OrdersDto(
        name = "Сорокин",
        image = R.drawable.choose_photo_overlay,
        data = "2022-03-08 20:10",
        time = "11:05",
        description = "первый заказ как блин комом",
        status = OrdersDto.StatusTYPE.INWORK,
        price = "70 500 Р"
    ),
    OrdersDto(
        name = "Сорокин",
        image = R.drawable.choose_photo_overlay,
        data = "2021-08-08 20:10",
        time = "11:05",
        description = "первый заказ как блин комом",
        status = OrdersDto.StatusTYPE.INWORK,
        price = "70 500 Р"
    ),
)