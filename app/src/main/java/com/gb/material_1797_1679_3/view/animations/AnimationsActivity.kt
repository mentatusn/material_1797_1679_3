package com.gb.material_1797_1679_3.view.animations

import android.graphics.Rect
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.*
import com.gb.material_1797_1679_3.R

import com.gb.material_1797_1679_3.databinding.ActivityAnimationsBinding
import com.gb.material_1797_1679_3.databinding.ActivityAnimationsExplodeBinding
import com.gb.material_1797_1679_3.databinding.ActivityAnimationsZoomBinding

class AnimationsActivity : AppCompatActivity() {

    lateinit var binding: ActivityAnimationsZoomBinding
    var flag = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsZoomBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imageView.setOnClickListener {

            val changeBounds = ChangeImageTransform()
            changeBounds.duration = 3000
            TransitionManager.beginDelayedTransition(binding.container,changeBounds)
            flag = !flag
            binding.imageView.scaleType = if(flag) ImageView.ScaleType.CENTER_CROP else ImageView.ScaleType.CENTER_INSIDE
        }
    }





}