package ui.smartpro.mirafox.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import ui.smartpro.mirafox.ui.orders.pages.CanceledWorkFragment
import ui.smartpro.mirafox.ui.orders.pages.DoneWorkFragment
import ui.smartpro.mirafox.ui.orders.pages.InWorkFragment
import ui.smartpro.mirafox.ui.orders.pages.NeedDateFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    val fragments =
        arrayOf(InWorkFragment(), NeedDateFragment(), DoneWorkFragment(), CanceledWorkFragment())

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]

}