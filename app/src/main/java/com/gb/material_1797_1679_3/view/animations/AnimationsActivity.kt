package com.gb.material_1797_1679_3.view.animations

import android.app.ActionBar
import android.graphics.Rect
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.*
import com.gb.material_1797_1679_3.R

import com.gb.material_1797_1679_3.databinding.ActivityAnimationsBinding
import com.gb.material_1797_1679_3.databinding.ActivityAnimationsExplodeBinding
import com.gb.material_1797_1679_3.databinding.ActivityAnimationsPathBinding
import com.gb.material_1797_1679_3.databinding.ActivityAnimationsZoomBinding

class AnimationsActivity : AppCompatActivity() {

    lateinit var binding: ActivityAnimationsPathBinding
    var flag = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsPathBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {

            val changeBounds = ChangeBounds()
            changeBounds.duration= 5000
            changeBounds.setPathMotion(ArcMotion())
            TransitionManager.beginDelayedTransition(binding.root,changeBounds)
            flag = !flag
            val params = binding.button.layoutParams as FrameLayout.LayoutParams
            params.gravity = if(flag) Gravity.BOTTOM or Gravity.END else Gravity.TOP or Gravity.START
            binding.button.layoutParams = params
        }
    }





}