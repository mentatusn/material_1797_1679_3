package com.gb.material_1797_1679_3.view.animations

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.transition.ChangeBounds
import androidx.transition.Fade
import androidx.transition.TransitionManager
import androidx.transition.TransitionSet
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
            val fade = Fade()
            fade.duration = 5000
            val changeBounds = ChangeBounds()
            changeBounds.duration = 2000
            transition.ordering = TransitionSet.ORDERING_SEQUENTIAL
            transition.addTransition(fade)
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