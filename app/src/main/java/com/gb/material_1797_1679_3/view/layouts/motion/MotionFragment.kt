package com.gb.material_1797_1679_3.view.layouts.motion

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.gb.material_1797_1679_3.databinding.FragmentConstraintBinding
import com.gb.material_1797_1679_3.databinding.FragmentMotionStartBinding


class MotionFragment : Fragment() {


    private var _binding: FragmentMotionStartBinding? = null
    private val binding: FragmentMotionStartBinding
        get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMotionStartBinding.inflate(inflater, container, false)
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
        fun newInstance() = MotionFragment()
    }
}