package com.gb.material_1797_1679_3.view.ux

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import com.gb.material_1797_1679_3.databinding.FragmentUxButtonBinding

import com.gb.material_1797_1679_3.databinding.FragmentUxTextBinding
import smartdevelop.ir.eram.showcaseviewlib.GuideView
import smartdevelop.ir.eram.showcaseviewlib.config.DismissType
import smartdevelop.ir.eram.showcaseviewlib.config.Gravity
import smartdevelop.ir.eram.showcaseviewlib.listener.GuideListener

class TutorialUXFragment : Fragment() {
    private var _binding: FragmentUxButtonBinding? = null
    private val binding: FragmentUxButtonBinding
        get() = _binding!!

    companion object{
        fun newInstance() = TutorialUXFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUxButtonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val builder = GuideView.Builder(requireContext())
            .setTitle("Устаревший подход")
            .setContentText("Мы не используем работу с цветом, размером и шрифтами")
            .setGravity(Gravity.center)
            .setDismissType(DismissType.anywhere)
            .setTargetView(binding.btnBad)
            .setDismissType(DismissType.anywhere)
            .setGuideListener(object : GuideListener {
                override fun onDismiss(view: View?) {

                    val builder2 = GuideView.Builder(requireContext())
                        .setTitle("Новый(material) подход")
                        .setContentText("Мы используем работу ТОЛЬКО с прозрачностями и пространством")
                        .setGravity(Gravity.center)
                        .setDismissType(DismissType.anywhere)
                        .setTargetView(binding.btnGood)
                        .setDismissType(DismissType.anywhere)
                        .setGuideListener(object : GuideListener {
                            override fun onDismiss(view: View?) {
                                // сохранить в SP то что уже показали, и больше не надо
                            }
                        })
                    builder2.build().show()

                }
            })
        builder.build().show()

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}