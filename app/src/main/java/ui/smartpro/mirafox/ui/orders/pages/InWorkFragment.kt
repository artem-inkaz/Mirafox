package ui.smartpro.mirafox.ui.orders.pages

import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.koin.androidx.viewmodel.ext.android.viewModel
import ui.smartpro.mirafox.R
import ui.smartpro.mirafox.base.BaseFragment
import ui.smartpro.mirafox.data.Orders
import ui.smartpro.mirafox.databinding.FragmentInWorkBinding
import ui.smartpro.mirafox.interfaces.OnItemViewClickListener
import ui.smartpro.mirafox.ui.orders.OrdersAppState
import ui.smartpro.mirafox.ui.orders.OrdersViewModel
import ui.smartpro.mirafox.ui.orders.adapters.OrdersListAdapter

class InWorkFragment(
    override val layoutId: Int = R.layout.fragment_in_work
) :
    BaseFragment<FragmentInWorkBinding>() {
    private val ordersViewModel by viewModel<OrdersViewModel>()
    private lateinit var ordersRv: RecyclerView

    override fun initViewModel() {
        super.initViewModel()
        ordersViewModel.getLiveData().observe(viewLifecycleOwner) { renderDataOrders(it) }
        ordersViewModel.getLessonsFromLocal()
    }

    private fun renderDataOrders(appState: OrdersAppState) {
        when (appState) {
            is OrdersAppState.Success -> {
                binding.includedLoadingLayout.loadingLayout.visibility = View.GONE
                binding.ordersRv.visibility = View.VISIBLE

                setOrdersData(appState.ordersData)
            }
            is OrdersAppState.Loading -> {
                binding.includedLoadingLayout.loadingLayout.visibility = View.VISIBLE
                binding.ordersRv.visibility = View.GONE

            }
            is OrdersAppState.Error -> {
                binding.includedLoadingLayout.loadingLayout.visibility = View.GONE
                binding.ordersRv.visibility = View.VISIBLE
            }
        }
    }

    private fun setOrdersData(orders: List<Orders>) {
        ordersRv = binding.ordersRv
        ordersRv.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        val ordersAdapter = OrdersListAdapter(object : OnItemViewClickListener {
            override fun onItemOrdersViewClick(orders: Orders) {

                val intent: Intent? =
                    Intent(Intent.ACTION_VIEW, Uri.parse("https://kwork.ru/"))
                if (intent != null) {
                    startActivity(intent)
                }
            }
        })
        ordersRv.adapter = ordersAdapter
        ordersAdapter.setOrdersList(orders)
    }
}