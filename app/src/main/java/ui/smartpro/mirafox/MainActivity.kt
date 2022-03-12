package ui.smartpro.mirafox

import android.os.Bundle
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import ui.smartpro.mirafox.data.getUserRole
import ui.smartpro.mirafox.databinding.ActivityMainBinding
import ui.smartpro.mirafox.databinding.ItemSpinnerBinding
import ui.smartpro.mirafox.spinner.CustomSpinner
import ui.smartpro.mirafox.spinner.SpinnerAdapter

class MainActivity : AppCompatActivity(), CustomSpinner.OnSpinnerEventsListener {
    lateinit var binding: ActivityMainBinding
    private lateinit var bottom_navigation: BottomNavigationView
    lateinit var navController: NavController
    lateinit var spinnerAdapter: SpinnerAdapter
    lateinit var customSpinner: CustomSpinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bottom_navigation = binding.bottomNavigation

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_main_fragment) as NavHostFragment
        navController = navHostFragment.navController
        initBottomNavigation()
        customSpinner = binding.roleSpinner
        customSpinner.setSpinnerEventsListener(this)
        spinnerAdapter = SpinnerAdapter(this@MainActivity, getUserRole())
        customSpinner.adapter = spinnerAdapter
    }

    private fun initBottomNavigation() {

        bottom_navigation.setOnItemSelectedListener {
            when (it.itemId) {

                R.id.action_chats -> {
                    navController.navigate(R.id.chatsFragment)
                    true
                }
                R.id.action_exchange -> {
                    navController.navigate(R.id.exchangeFragment)
                    true
                }
                R.id.action_orders -> {
                    navController.navigate(R.id.ordersFragment)
                    true
                }
                R.id.action_notifications -> {
                    navController.navigate(R.id.notificationsFragment)
                    true
                }
                R.id.action_profile -> {
                    navController.navigate(R.id.profileFragment)
                    true
                }

                else -> true
            }
        }
    }

    override fun onPopupWindowOpened(spinner: Spinner?) {
        customSpinner.background = resources.getDrawable(R.drawable.bg_spinner_up, theme)
    }

    override fun onPopupWindowClosed(spinner: Spinner?) {
        customSpinner.background = resources.getDrawable(R.drawable.bg_spinner_down, theme)
    }
}