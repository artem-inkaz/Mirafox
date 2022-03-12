package ui.smartpro.mirafox.ui.orders

import android.view.LayoutInflater
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import ui.smartpro.mirafox.R
import ui.smartpro.mirafox.base.BaseFragment
import ui.smartpro.mirafox.databinding.OrdersFragmentBinding
import ui.smartpro.mirafox.utils.CANCELEDWORK
import ui.smartpro.mirafox.utils.DONEWORK
import ui.smartpro.mirafox.utils.INWORK
import ui.smartpro.mirafox.utils.NEEDDATA
import ui.smartpro.mirafox.viewpager.ViewPagerAdapter

class OrdersFragment(
    override val layoutId: Int = R.layout.orders_fragment
) :
    BaseFragment<OrdersFragmentBinding>() {
    override fun initViews() {
        super.initViews()
        viewPagerInit()
    }

    private fun viewPagerInit() {
        val vpAdapter = ViewPagerAdapter(requireActivity())
        binding.viewPager.adapter = vpAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = vpAdapter.fragments[position].javaClass.name

        }.attach()
        setHighlightedTab(INWORK)

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                setHighlightedTab(tab.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    private fun setHighlightedTab(position: Int) {
        val layoutInflater = LayoutInflater.from(context)

        binding.tabLayout.getTabAt(INWORK)?.customView = null
        binding.tabLayout.getTabAt(NEEDDATA)?.customView = null
        binding.tabLayout.getTabAt(DONEWORK)?.customView = null
        binding.tabLayout.getTabAt(CANCELEDWORK)?.customView = null
        when (position) {
            INWORK -> {
                setInWorkTabHighlighted(layoutInflater)
            }
            NEEDDATA -> {
                setNeedDateTabHighlighted(layoutInflater)
            }
            DONEWORK -> {
                setDoneWorkTabHighlighted(layoutInflater)
            }
            CANCELEDWORK -> {
                setCanceledWorkTabHighlighted(layoutInflater)
            }
            else -> {
                setInWorkTabHighlighted(layoutInflater)
            }
        }
    }

    private fun setInWorkTabHighlighted(layoutInflater: LayoutInflater?) {
        val inWork =
            layoutInflater?.inflate(R.layout.tab_in_work, null)
        inWork?.findViewById<AppCompatTextView>(R.id.in_work_btn)?.setTextColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.white
            )
        )
        inWork?.findViewById<AppCompatTextView>(R.id.in_work_btn)
            ?.setBackgroundResource(R.drawable.base_button_shape)

        binding.tabLayout.getTabAt(INWORK)?.customView = inWork
        binding.tabLayout.getTabAt(NEEDDATA)?.customView =
            layoutInflater?.inflate(R.layout.tab_need_date, null)
        binding.tabLayout.getTabAt(DONEWORK)?.customView =
            layoutInflater?.inflate(R.layout.tab_done_work, null)
        binding.tabLayout.getTabAt(CANCELEDWORK)?.customView =
            layoutInflater?.inflate(R.layout.tab_canceled_work, null)
    }

    private fun setNeedDateTabHighlighted(layoutInflater: LayoutInflater) {
        val needDate =
            layoutInflater.inflate(R.layout.tab_need_date, null)
        needDate.findViewById<AppCompatTextView>(R.id.need_date_btn)
            .setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.white
                )
            )
        needDate?.findViewById<AppCompatTextView>(R.id.need_date_btn)
            ?.setBackgroundResource(R.drawable.base_button_shape)

        binding.tabLayout.getTabAt(INWORK)?.customView =
            layoutInflater.inflate(R.layout.tab_in_work, null)

        binding.tabLayout.getTabAt(NEEDDATA)?.customView = needDate

        binding.tabLayout.getTabAt(DONEWORK)?.customView =
            layoutInflater?.inflate(R.layout.tab_done_work, null)
        binding.tabLayout.getTabAt(CANCELEDWORK)?.customView =
            layoutInflater?.inflate(R.layout.tab_canceled_work, null)

    }

    private fun setDoneWorkTabHighlighted(layoutInflater: LayoutInflater) {
        val doneWork =
            layoutInflater.inflate(R.layout.tab_done_work, null)
        doneWork.findViewById<AppCompatTextView>(R.id.done_work_btn)
            .setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.white
                )
            )
        doneWork?.findViewById<AppCompatTextView>(R.id.done_work_btn)
            ?.setBackgroundResource(R.drawable.base_button_shape)

        binding.tabLayout.getTabAt(INWORK)?.customView =
            layoutInflater.inflate(R.layout.tab_in_work, null)
        binding.tabLayout.getTabAt(NEEDDATA)?.customView =
            layoutInflater.inflate(R.layout.tab_need_date, null)

        binding.tabLayout.getTabAt(DONEWORK)?.customView = doneWork
        binding.tabLayout.getTabAt(CANCELEDWORK)?.customView =
            layoutInflater?.inflate(R.layout.tab_canceled_work, null)

    }

    private fun setCanceledWorkTabHighlighted(layoutInflater: LayoutInflater) {
        val canceledWork =
            layoutInflater.inflate(R.layout.tab_canceled_work, null)
        canceledWork.findViewById<AppCompatTextView>(R.id.canceled_work_btn)
            .setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.white
                )
            )
        canceledWork?.findViewById<AppCompatTextView>(R.id.canceled_work_btn)
            ?.setBackgroundResource(R.drawable.base_button_shape)
        binding.tabLayout.getTabAt(INWORK)?.customView =
            layoutInflater.inflate(R.layout.tab_in_work, null)
        binding.tabLayout.getTabAt(NEEDDATA)?.customView =
            layoutInflater.inflate(R.layout.tab_need_date, null)
        binding.tabLayout.getTabAt(DONEWORK)?.customView =
            layoutInflater.inflate(R.layout.tab_done_work, null)
        binding.tabLayout.getTabAt(CANCELEDWORK)?.customView = canceledWork

    }
}