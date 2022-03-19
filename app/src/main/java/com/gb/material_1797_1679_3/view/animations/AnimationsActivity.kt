package com.gb.material_1797_1679_3.view.animations

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
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
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.*
import com.gb.material_1797_1679_3.R
import com.gb.material_1797_1679_3.databinding.*

class AnimationsActivity : AppCompatActivity() {

    val duration = 1000L

    lateinit var binding: ActivityAnimationsRotateFabBinding
    var flag = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsRotateFabBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.scrollView.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            binding.header.isSelected = binding.scrollView.canScrollVertically(-1)
        }
    }

}