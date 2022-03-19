package com.gb.material_1797_1679_3.view.animations

import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.transition.*
import com.gb.material_1797_1679_3.databinding.ActivityAnimationsBinding

class AnimationsActivity:AppCompatActivity() {

    lateinit var binding: ActivityAnimationsBinding
    var flag = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {

            val transition = TransitionSet()
            val slide = Slide()
            slide.duration = 5000
            slide.slideEdge = Gravity.END
            val changeBounds = ChangeBounds()
            changeBounds.duration = 2000
            transition.ordering = TransitionSet.ORDERING_TOGETHER
            transition.addTransition(slide)
            transition.addTransition(changeBounds)
            TransitionManager.beginDelayedTransition(binding.transitionsContainer,transition)

            flag = !flag
            binding.text.visibility =  if(flag) View.VISIBLE else View.GONE

        }

        /*(requireActivity() as MainActivity).runOnUiThread {
            binding.btnYes.visibility = View.GONE
        }*/
    }
}