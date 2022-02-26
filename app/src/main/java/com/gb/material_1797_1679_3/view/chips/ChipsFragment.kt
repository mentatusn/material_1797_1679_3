package com.gb.material_1797_1679_3.view.chips

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.FrameLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.gb.material_1797_1679_3.R
import com.gb.material_1797_1679_3.databinding.FragmentChipsBinding
import com.gb.material_1797_1679_3.databinding.FragmentMainBinding
import com.gb.material_1797_1679_3.view.MainActivity
import com.gb.material_1797_1679_3.view.main.BottomNavigationDrawerFragment
import com.gb.material_1797_1679_3.viewmodel.PictureOfTheDayState
import com.gb.material_1797_1679_3.viewmodel.PictureOfTheDayViewModel
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.chip.Chip
import com.google.android.material.tabs.TabItem

class ChipsFragment : Fragment() {
    private var _binding: FragmentChipsBinding? = null
    private val binding: FragmentChipsBinding
        get() = _binding!!

    companion object {
        fun newInstance() = ChipsFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChipsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.chipGroup.setOnCheckedChangeListener{ group, checkedId ->
            binding.chipGroup.findViewById<Chip>(checkedId)?.let{
                Toast.makeText(requireContext(),"chip $checkedId ${it.text}",Toast.LENGTH_SHORT).show()
            }
        }
        binding.tabs.getTabAt(0)!!.text = "РАБОТАЕТ"
        //binding.cardView.setBackgroundDrawable(resources.getDrawable(R.drawable.gradient))
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}