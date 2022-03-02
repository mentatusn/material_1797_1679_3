package com.gb.material_1797_1679_3.view.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.TextView
import com.gb.material_1797_1679_3.R
import com.gb.material_1797_1679_3.databinding.ActivityNavigationBinding
import com.gb.material_1797_1679_3.view.main.PictureOfTheDayFragment

class NavigationActivity : AppCompatActivity() {

    lateinit var binding : ActivityNavigationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewPager.adapter = ViewPagerAdapter(supportFragmentManager)
    }

}