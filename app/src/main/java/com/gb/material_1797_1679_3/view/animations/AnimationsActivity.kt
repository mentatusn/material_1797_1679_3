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
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.*
import com.gb.material_1797_1679_3.R
import com.gb.material_1797_1679_3.databinding.*

class AnimationsActivity : AppCompatActivity() {

    lateinit var binding: ActivityAnimationsShuffleBinding
    var flag = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsShuffleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val titles: MutableList<String> = ArrayList()
        repeat(5) {
            titles.add("item $it")
        }
        binding.button.setOnClickListener {
            TransitionManager.beginDelayedTransition(binding.transitionsContainer)
            titles.shuffle()
            binding.transitionsContainer.removeAllViews()
            titles.forEach { title:String->
                binding.transitionsContainer.addView(TextView(this).apply {
                    text = title
                    ViewCompat.setTransitionName(this,title)
                })
            }
        }
    }





}