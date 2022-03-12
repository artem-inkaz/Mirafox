package ui.smartpro.mirafox.data

data class User(
    var id: Int? = null,
    var role: String = ""
)

fun getUserRole() = listOf<User>(
    User(id = 0, role = "Я Покупатель"),
    User(id = 1, role = "Я Продавец")
)