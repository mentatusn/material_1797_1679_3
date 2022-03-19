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

        val constraintSet= ConstraintSet()
        constraintSet.clone(binding.constraintContainer)

        binding.backgroundImage.setOnClickListener {
            flag = !flag
            val changeBounds = ChangeBounds()
            changeBounds.interpolator = AnticipateOvershootInterpolator(2.0f)
            changeBounds.duration= 1000L
            changeBounds.addListener(object : Transition.TransitionListener {
                override fun onTransitionStart(transition: Transition) {

                }

                override fun onTransitionEnd(transition: Transition) {
                    Handler(mainLooper).postDelayed({

                        flag = !flag
                        val changeBounds = ChangeBounds()
                        changeBounds.interpolator = AnticipateOvershootInterpolator(2.0f)
                        changeBounds.duration= 1000L
                        TransitionManager.beginDelayedTransition(binding.constraintContainer,changeBounds)

                        constraintSet.connect(R.id.title,ConstraintSet.END,R.id.backgroundImage,ConstraintSet.START)
                        constraintSet.clear(R.id.title,ConstraintSet.START)
                        constraintSet.applyTo(binding.constraintContainer)
                    },
                        1000L)
                }

                override fun onTransitionCancel(transition: Transition) {

                }

                override fun onTransitionPause(transition: Transition) {

                }

                override fun onTransitionResume(transition: Transition) {

                }

            });
            TransitionManager.beginDelayedTransition(binding.constraintContainer,changeBounds)
            if(flag){
                constraintSet.connect(R.id.title,ConstraintSet.END,R.id.constraint_container,ConstraintSet.END)
                constraintSet.connect(R.id.title,ConstraintSet.START,R.id.constraint_container,ConstraintSet.START)
                constraintSet.setHorizontalBias(R.id.title,0.8f)
                constraintSet.constrainPercentWidth(R.id.title,0.5f)
                //constraintSet.clear(R.id.title,ConstraintSet.END)
                constraintSet.applyTo(binding.constraintContainer)


            }else{
                constraintSet.connect(R.id.title,ConstraintSet.END,R.id.backgroundImage,ConstraintSet.START)
                constraintSet.clear(R.id.title,ConstraintSet.START)
                constraintSet.applyTo(binding.constraintContainer)
            }
        }
    }

}