package com.gb.material_1797_1679_3.view.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.TextView
import android.widget.Toast
import com.gb.material_1797_1679_3.R
import com.gb.material_1797_1679_3.databinding.ActivityBottomNavigationBinding
import com.gb.material_1797_1679_3.databinding.ActivityNavigationBinding
import com.gb.material_1797_1679_3.view.chips.ChipsFragment
import com.gb.material_1797_1679_3.view.main.BottomNavigationDrawerFragment
import com.gb.material_1797_1679_3.view.main.PictureOfTheDayFragment

class BottomNavigationActivity : AppCompatActivity() {

    lateinit var binding: ActivityBottomNavigationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_view_earth -> {
                    true
                }
                R.id.bottom_view_mars -> {
                    true
                }
                R.id.bottom_view_system -> {
                    true
                }
                else -> true
            }
        }

    }

}