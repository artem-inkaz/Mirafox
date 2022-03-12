package ui.smartpro.mirafox.ui.orders

import android.app.Application
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.launch
import ui.smartpro.mirafox.api.Api
import ui.smartpro.mirafox.base.BaseViewModel
import ui.smartpro.mirafox.repository.ordersinteractor.OrdersInteractor
import ui.smartpro.mirafox.repository.ordersinteractor.OrdersInteractorImpl

class OrdersViewModel(
    app: Application,
    private val apiService: Api,
    private val liveDataToObserve: MutableLiveData<OrdersAppState> =
        MutableLiveData(),
    private val ordersInteractorImpl: OrdersInteractor = OrdersInteractorImpl()
) : BaseViewModel(app) {

    fun getLiveData() = liveDataToObserve

    fun getLessonsFromLocal() = getDataFromLocalSource()

    private fun getDataFromLocalSource() {
        modelScope.launch {
            val ordersFromApi = apiService.getOrdersDto()
            liveDataToObserve.value = OrdersAppState.Loading
            Thread.sleep(700)
            liveDataToObserve.postValue(
                OrdersAppState.Success(
                    ordersInteractorImpl.getOrders(ordersFromApi)
                )
            )
        }
    }
}