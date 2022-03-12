package ui.smartpro.mirafox.spinner

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import ui.smartpro.mirafox.R
import ui.smartpro.mirafox.data.User

class SpinnerAdapter(private val context: Context, role: List<User>?) :
    BaseAdapter() {
    private val roleUser: List<User>? = role
    val layoutInflater: LayoutInflater = LayoutInflater.from(context)
    override fun getCount(): Int {
        return roleUser?.size ?: 0
    }

    override fun getItem(i: Int): Any {
        return i
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.item_spinner, parent, false)
            val txtName: TextView = view.findViewById<TextView>(R.id.role_user)
            txtName.text = roleUser?.get(position)?.role
            txtName.textSize = 15F
        } else {
            view = convertView
        }
        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = layoutInflater.inflate(R.layout.item_spinner_drop, parent, false)
        val constraintLayout = view.findViewById<ConstraintLayout>(R.id.container_spinner)
        val layoutParams = constraintLayout.layoutParams
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT
        constraintLayout.layoutParams = layoutParams
        val txtName: TextView = view.findViewById<TextView>(R.id.role_user)
        val image: ImageView = view.findViewById<ImageView>(R.id.check_role)
        txtName.text = roleUser?.get(position)?.role
        txtName.textSize = 20F
        if (roleUser?.get(position)?.id == 0) image.visibility = View.VISIBLE
        return view
    }
}