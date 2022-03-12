package ui.smartpro.mirafox.di

import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ui.smartpro.mirafox.api.Api
import ui.smartpro.mirafox.api.ApiImpl
import ui.smartpro.mirafox.repository.ordersinteractor.OrdersInteractor
import ui.smartpro.mirafox.repository.ordersinteractor.OrdersInteractorImpl
import ui.smartpro.mirafox.ui.orders.OrdersViewModel

val appModule = module {
    //repo
    single<Api> { ApiImpl() }
    single<OrdersInteractor> { OrdersInteractorImpl() }
    //vm
    viewModel { OrdersViewModel(androidApplication(), get()) }
}