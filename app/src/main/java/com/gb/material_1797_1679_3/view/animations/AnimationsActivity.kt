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
import android.view.animation.AnticipateInterpolator
import android.view.animation.AnticipateOvershootInterpolator
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.*
import com.gb.material_1797_1679_3.R
import com.gb.material_1797_1679_3.databinding.*

class AnimationsActivity : AppCompatActivity() {

    val duration = 1000L

    lateinit var binding: ActivityAnimationsBonusStartBinding
    var flag = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsBonusStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backgroundImage.setOnClickListener {
            flag = !flag
            if(flag){
                val changeBounds = ChangeBounds()
                changeBounds.interpolator = AnticipateOvershootInterpolator(2.0f)
                changeBounds.duration= 1000L
                TransitionManager.beginDelayedTransition(binding.constraintContainer,changeBounds)

                val constraintSet= ConstraintSet()
                constraintSet.clone(this,R.layout.activity_animations_bonus_end)
                constraintSet.applyTo(binding.constraintContainer)
            }else{
                val changeBounds = ChangeBounds()
                changeBounds.interpolator = AnticipateOvershootInterpolator(2.0f)
                changeBounds.duration= 1000L
                TransitionManager.beginDelayedTransition(binding.constraintContainer,changeBounds)

                val constraintSet= ConstraintSet()
                constraintSet.clone(this,R.layout.activity_animations_bonus_start)
                constraintSet.applyTo(binding.constraintContainer)
            }
        }
    }

}