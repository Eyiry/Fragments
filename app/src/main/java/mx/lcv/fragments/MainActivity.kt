package mx.lcv.fragments

import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initial Fragment
        val fragHome = HomeFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragHome).commit()


        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navView.setOnNavigationItemReselectedListener { menuItem ->

            when (menuItem.itemId){
                R.id.navigation_home -> {
                    val fragHome = HomeFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragHome)
                        .addToBackStack(null).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit()

                }
                R.id.navigation_other -> {
                    val fraOther = OtherFrag()
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fraOther)
                        .addToBackStack(null).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit()
                }
                R.id.navigation_notifications ->{
                    val fragNotification = NotificationFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragNotification)
                        .addToBackStack(null).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit()
                }
                R.id.navigation_dashboard -> {
                    val fragDash = DashboardFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragDash)
                        .addToBackStack(null).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit()
                }
            }

            true
        }


    }
}
