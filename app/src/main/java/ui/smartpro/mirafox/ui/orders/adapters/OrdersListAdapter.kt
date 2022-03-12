package ui.smartpro.mirafox.ui.orders.adapters

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import ui.smartpro.mirafox.R
import ui.smartpro.mirafox.data.Orders
import ui.smartpro.mirafox.databinding.ItemOrdersBinding
import ui.smartpro.mirafox.interfaces.OnItemViewClickListener

class OrdersListAdapter(
    private var onItemViewClickListener:
    OnItemViewClickListener
) : RecyclerView.Adapter<OrdersListAdapter.OrdersListViewHolder>() {

    private var ordersList: List<Orders> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = OrdersListViewHolder(
        ItemOrdersBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
    )

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: OrdersListViewHolder, position: Int) {
        holder.bind(ordersList[position])
        holder.itemView.setOnClickListener {
            onItemViewClickListener.onItemOrdersViewClick(ordersList[position])
        }
    }

    override fun getItemCount(): Int = ordersList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setOrdersList(orders: List<Orders>) {
        this.ordersList = orders
        notifyDataSetChanged()
    }

    inner class OrdersListViewHolder(private val vb: ItemOrdersBinding) :
        RecyclerView.ViewHolder(vb.root) {

        fun bind(orders: Orders) = with(vb) {
            if (layoutPosition != RecyclerView.NO_POSITION) {
                timeOrder.text = orders.data
                userName.text = orders.name
                descriptionOrder.text = orders.description
                statusOrderTv.text = orders.status
                orders.image.let { userPhoto.setImageResource(R.drawable.choose_photo_overlay) }
            }
        }
    }
}