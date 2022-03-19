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

        binding.fab.setOnClickListener {
            flag = !flag
            if(flag){
                ObjectAnimator.ofFloat( binding.plusImageview,View.ROTATION,0f,405f).setDuration(duration).start()
                ObjectAnimator.ofFloat( binding.optionOneContainer,View.TRANSLATION_Y,-50f,-260f).setDuration(duration).start()
                ObjectAnimator.ofFloat( binding.optionTwoContainer,View.TRANSLATION_Y,-20f,-130f).setDuration(duration).start()

                binding.optionOneContainer.animate()
                    .alpha(1f)
                    .setDuration(duration/2)
                    .setListener(object : AnimatorListenerAdapter(){
                        override fun onAnimationEnd(animation: Animator?) {
                            super.onAnimationEnd(animation)
                            binding.optionOneContainer.isClickable = true
                        }
                    })
                binding.optionTwoContainer.animate()
                    .alpha(1f)
                    .setDuration(duration/2)
                    .setListener(object : AnimatorListenerAdapter(){
                        override fun onAnimationEnd(animation: Animator?) {
                            super.onAnimationEnd(animation)
                            binding.optionTwoContainer.isClickable = true
                        }
                    })

                binding.transparentBackground.animate()
                    .alpha(0.5f)
                    .setDuration(duration)
            }else{
                ObjectAnimator.ofFloat( binding.plusImageview,View.ROTATION,405f,0f).setDuration(duration).start()
                ObjectAnimator.ofFloat( binding.optionOneContainer,View.TRANSLATION_Y,-260f,-50f).setDuration(duration).start()
                ObjectAnimator.ofFloat( binding.optionTwoContainer,View.TRANSLATION_Y,-130f,-20f).setDuration(duration).start()

                binding.optionOneContainer.animate()
                    .alpha(0f)
                    .setDuration(duration/2)
                    .setListener(object : AnimatorListenerAdapter(){
                        override fun onAnimationEnd(animation: Animator?) {
                            super.onAnimationEnd(animation)
                            binding.optionOneContainer.isClickable = false
                        }
                    })
                binding.optionTwoContainer.animate()
                    .alpha(0f)
                    .setDuration(duration/2)
                    .setListener(object : AnimatorListenerAdapter(){
                        override fun onAnimationEnd(animation: Animator?) {
                            super.onAnimationEnd(animation)
                            binding.optionTwoContainer.isClickable = false
                        }
                    })
                binding.transparentBackground.animate()
                    .alpha(0f)
                    .setDuration(duration)

            }
        }
    }

}