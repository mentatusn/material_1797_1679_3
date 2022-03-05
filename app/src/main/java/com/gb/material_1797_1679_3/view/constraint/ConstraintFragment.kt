package com.gb.material_1797_1679_3.view.constraint

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.gb.material_1797_1679_3.R
import com.gb.material_1797_1679_3.databinding.FragmentConstraintBinding
import com.gb.material_1797_1679_3.databinding.FragmentEarthBinding
import com.gb.material_1797_1679_3.databinding.FragmentMainBinding


class ConstraintFragment : Fragment() {


    private var _binding: FragmentConstraintBinding? = null
    private val binding: FragmentConstraintBinding
        get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConstraintBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }




    companion object {
        @JvmStatic
        fun newInstance() = ConstraintFragment()
    }
}