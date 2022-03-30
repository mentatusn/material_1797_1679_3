package com.gb.material_1797_1679_3.view.ux

import android.content.Intent
import android.graphics.Typeface
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Html
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.SpannedString
import android.text.style.*
import android.util.Log
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.provider.FontRequest
import androidx.core.provider.FontsContractCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.gb.material_1797_1679_3.R
import com.gb.material_1797_1679_3.databinding.FragmentMainBinding
import com.gb.material_1797_1679_3.databinding.FragmentUxBinding
import com.gb.material_1797_1679_3.view.MainActivity
import com.gb.material_1797_1679_3.view.chips.ChipsFragment
import com.gb.material_1797_1679_3.view.main.BottomNavigationDrawerFragment
import com.gb.material_1797_1679_3.viewmodel.PictureOfTheDayState
import com.gb.material_1797_1679_3.viewmodel.PictureOfTheDayViewModel
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomsheet.BottomSheetBehavior
import java.util.regex.Pattern

class UXFragment : Fragment() {
    private var _binding: FragmentUxBinding? = null
    private val binding: FragmentUxBinding
        get() = _binding!!

    companion object{
        fun newInstance() = UXFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUxBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}