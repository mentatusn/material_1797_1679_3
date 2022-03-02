package com.gb.material_1797_1679_3.view.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.TextView
import com.gb.material_1797_1679_3.R
import com.gb.material_1797_1679_3.databinding.ActivityNavigationBinding
import com.gb.material_1797_1679_3.view.main.PictureOfTheDayFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class NavigationActivity : AppCompatActivity() {

    lateinit var binding: ActivityNavigationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewPager.adapter = ViewPagerAdapter(this)

        TabLayoutMediator(binding.tabLayout,binding.viewPager
        ) { tab, position ->
            tab.text = when (position) {
                EARTH_KEY -> "Earth"
                MARS_KEY -> "Mars"
                SYSTEM_KEY -> "System"
                else -> "Earth"
            }
        }.attach()

        /*binding.tabLayout.getTabAt(EARTH_KEY)?.setIcon(R.drawable.ic_earth)
        binding.tabLayout.getTabAt(MARS_KEY)?.setIcon(R.drawable.ic_mars)
        binding.tabLayout.getTabAt(SYSTEM_KEY)?.setIcon(R.drawable.ic_system)*/

       /* binding.tabLayout.getTabAt(EARTH_KEY)?.setCustomView(R.layout.activity_navigation_tablayout_item_earth)
        binding.tabLayout.getTabAt(MARS_KEY)?.setCustomView(R.layout.activity_navigation_tablayout_item_mars)
        binding.tabLayout.getTabAt(SYSTEM_KEY)?.setCustomView(R.layout.activity_navigation_tablayout_item_system)*/


    }

}