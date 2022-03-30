package com.gb.material_1797_1679_3.view.ux

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.gb.material_1797_1679_3.databinding.FragmentUxButtonBinding

import com.gb.material_1797_1679_3.databinding.FragmentUxTextBinding

class ButtonUXFragment : ViewBindingFragment<FragmentUxButtonBinding>(FragmentUxButtonBinding::inflate) {
    companion object{
        fun newInstance() = ButtonUXFragment()
    }
}