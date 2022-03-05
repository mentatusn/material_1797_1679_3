package com.gb.material_1797_1679_3.view.navigation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.gb.material_1797_1679_3.R
import com.gb.material_1797_1679_3.databinding.FragmentMarsBinding


class MarsFragment : Fragment() {


    private var _binding: FragmentMarsBinding? = null
    val binding: FragmentMarsBinding
        get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMarsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_bottom_bar, menu)
    }



    companion object {
        @JvmStatic
        fun newInstance() = MarsFragment()
    }
}