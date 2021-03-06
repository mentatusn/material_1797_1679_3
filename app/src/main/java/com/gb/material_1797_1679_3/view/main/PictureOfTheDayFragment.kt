package com.gb.material_1797_1679_3.view.main

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
import com.gb.material_1797_1679_3.view.MainActivity
import com.gb.material_1797_1679_3.view.chips.ChipsFragment
import com.gb.material_1797_1679_3.viewmodel.PictureOfTheDayState
import com.gb.material_1797_1679_3.viewmodel.PictureOfTheDayViewModel
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.loadOrCueVideo
import java.util.regex.Pattern

class PictureOfTheDayFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = _binding!!

    companion object {
        fun newInstance() = PictureOfTheDayFragment()
    }

    private val viewModel: PictureOfTheDayViewModel by lazy {
        ViewModelProvider(this).get(PictureOfTheDayViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        (requireActivity() as MainActivity).setSupportActionBar(binding.bottomAppBar)
        viewModel.getLiveData().observe(viewLifecycleOwner, Observer { renderData(it) })
        viewModel.sendServerRequest()

        (requireActivity() as MainActivity).runOnUiThread {
            binding.btnYes.visibility = View.GONE
        }

        binding.inputLayout.setEndIconOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW).apply {
                data =
                    Uri.parse("https://en.wikipedia.org/wiki/${binding.inputEditText.text.toString()}")
            })
        }

        bottomSheetBehavior = BottomSheetBehavior.from(binding.included.bottomSheetContainer)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED

        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    /*BottomSheetBehavior.STATE_DRAGGING -> TODO("not implemented")
                    BottomSheetBehavior.STATE_COLLAPSED -> TODO("not implemented")
                    BottomSheetBehavior.STATE_EXPANDED -> TODO("not implemented")
                    BottomSheetBehavior.STATE_HALF_EXPANDED -> TODO("not implemented")
                    BottomSheetBehavior.STATE_HIDDEN -> TODO("not implemented")
                    BottomSheetBehavior.STATE_SETTLING -> TODO("not implemented")*/
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                Log.d("mylogs", "$slideOffset slideOffset")
            }
        })


        binding.fab.setOnClickListener {
            if (isMain) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                binding.bottomAppBar.navigationIcon = null
                binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
                binding.fab.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_back_fab
                    )
                )
                binding.bottomAppBar.replaceMenu(R.menu.menu_bottom_bar_other_screen)
            } else {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
                binding.bottomAppBar.navigationIcon = ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.ic_hamburger_menu_bottom_bar
                )
                binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
                binding.fab.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_plus_fab
                    )
                )
                binding.bottomAppBar.replaceMenu(R.menu.menu_bottom_bar)
            }
            isMain = !isMain
        }



        binding.btnYes.setOnClickListener {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        binding.btnNo.setOnClickListener {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        val request = FontRequest(
            "com.google.android.gms.fonts", "com.google.android.gms",
            "Aguafina Script", R.array.com_google_android_gms_fonts_certs
        )

        val callback = object : FontsContractCompat.FontRequestCallback() {
            override fun onTypefaceRetrieved(typeface: Typeface?) {
                binding.included.bottomSheetDescription.typeface = typeface
                super.onTypefaceRetrieved(typeface)
            }
        }
        FontsContractCompat.requestFont(
            requireContext(),
            request,
            callback,
            Handler(Looper.myLooper()!!)
        )

    }

    var isMain: Boolean = true

    fun extractYTId(ytUrl: String): String {
        var vId: String? = null
        val pattern = Pattern.compile(
            "^https?://.*(?:youtu.be/|v/|u/\\w/|embed/|watch?v=)([^#&?]*).*$",
            Pattern.CASE_INSENSITIVE
        )
        val matcher = pattern.matcher(ytUrl)
        if (matcher.matches()) {
            vId = matcher.group(1)
        }
        return vId!!
    }


    private fun showAVideoUrl(videoUrl: String) = with(binding) {
        with(binding) {
            imageView.visibility = View.GONE
            videoOfTheDay.visibility = View.VISIBLE
            videoOfTheDay.text = "?????????????? ?? ?????? ?????? ???????????????? ??????, ???? ????????  ?????????? ??????! " +
                    "${videoUrl.toString()} \n ???????????? >??????????< ?????????? ?????????????? ?? ?????????? ????????"
            videoOfTheDay.setOnClickListener {
                val i = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse(videoUrl)
                }
                startActivity(i)
            }
        }

    }

    private fun showNasaVideo(videoId: String) {
        with(binding) {
            lifecycle.addObserver(binding.youtubePlayer)

            youtubePlayer.addYouTubePlayerListener(object :
                AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    //youTubePlayer.loadVideo(videoId, 0f)
                    youTubePlayer.cueVideo(videoId, 0f)
                    // youTubePlayer.pause()
                }
            })
        }
    }


    private fun renderData(pictureOfTheDayState: PictureOfTheDayState) {
        when (pictureOfTheDayState) {
            is PictureOfTheDayState.Error -> {
                // TODO HW
            }
            is PictureOfTheDayState.Loading -> {
                // TODO HW
            }
            is PictureOfTheDayState.Success -> {

                if (pictureOfTheDayState.serverResponseData.mediaType == "video") {
                    //showAVideoUrl(pictureOfTheDayState.serverResponseData.url)
                    binding.youtubePlayer.visibility = View.VISIBLE
                    binding.imageView.visibility = View.GONE
                    showNasaVideo(extractYTId(pictureOfTheDayState.serverResponseData.url))
                } else {
                    binding.youtubePlayer.visibility = View.GONE
                    binding.imageView.visibility = View.VISIBLE
                    binding.imageView.load(pictureOfTheDayState.serverResponseData.hdurl)
                }



                binding.included.bottomSheetDescription.text =
                    "???????? ???????? ???????? ${pictureOfTheDayState.serverResponseData.explanation}"


                /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    binding.included.bottomSheetDescription.typeface = resources.getFont(R.font.robus)
                }else{
                    binding.included.bottomSheetDescription.typeface = Typeface.createFromAsset(requireActivity().assets,
                        "folder1/folder2/font/Robus-BWqOd.otf")
                }*/

                /*val text = "My text <ul><li>bullet one</li><li>bullet two</li></ul>"
                binding.included.bottomSheetDescription.text = Html.fromHtml(text,Html.FROM_HTML_MODE_COMPACT)*/

                val text = pictureOfTheDayState.serverResponseData.explanation
                var spannableStringBuilder = SpannableStringBuilder(text)
                val spannableString = SpannableString(text)
                val spannedString = SpannedString(spannableStringBuilder)

                binding.included.bottomSheetDescription.setText(
                    spannableStringBuilder,
                    TextView.BufferType.EDITABLE
                )
                //binding.included.bottomSheetDescription.setText(spannableString,TextView.BufferType.SPANNABLE)
                spannableStringBuilder =
                    binding.included.bottomSheetDescription.text as SpannableStringBuilder


                //text.split("\n").forEach { it.length }

                spannableStringBuilder.insert(3, "\n")
                spannableStringBuilder.insert(9, "\n")

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    spannableStringBuilder.setSpan(
                        BulletSpan(
                            200,
                            ContextCompat.getColor(requireContext(), R.color.colorAccent),
                            20
                        ), 4, 10, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                }




                spannableStringBuilder.setSpan(
                    ForegroundColorSpan(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.colorAccent
                        )
                    ),
                    0,
                    spannableStringBuilder.length / 2,
                    SpannableString.SPAN_INCLUSIVE_INCLUSIVE
                )
                spannableStringBuilder.setSpan(
                    ForegroundColorSpan(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.teal_200
                        )
                    ),
                    spannableStringBuilder.length / 2,
                    spannableStringBuilder.length,
                    SpannableString.SPAN_INCLUSIVE_INCLUSIVE
                )




                spannableStringBuilder.insert(spannableStringBuilder.length / 2, "MMMMMMMMMMMMM")
                spannableStringBuilder.insert(0, "LLLLLLLLLLLLLL")

                spannableStringBuilder.insert(spannableStringBuilder.length, "RRRRRRRRRRRRR")

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    spannableStringBuilder.setSpan(
                        TypefaceSpan(
                            Typeface.createFromAsset(
                                requireActivity().assets,
                                "folder1/folder2/font/Robus-BWqOd.otf"
                            )
                        ),
                        0,
                        spannableStringBuilder.length / 2,
                        SpannableString.SPAN_INCLUSIVE_INCLUSIVE
                    )
                }

                spannableStringBuilder.setSpan(
                    ForegroundColorSpan(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.purple_700
                        )
                    ), 0, 1, SpannableString.SPAN_INCLUSIVE_INCLUSIVE
                )


                spannableStringBuilder.indices.forEach {
                    if (spannableStringBuilder[it] == ('o')) {
                        spannableStringBuilder.setSpan(
                            ImageSpan(
                                requireContext(), R.drawable.ic_earth,
                                DynamicDrawableSpan.ALIGN_CENTER
                            ), it, it + 1, SpannableString.SPAN_INCLUSIVE_INCLUSIVE
                        )
                    }
                }

            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_bottom_bar, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.app_bar_fav -> Toast.makeText(requireContext(), "app_bar_fav", Toast.LENGTH_SHORT)
                .show()
            R.id.app_bar_settings -> {
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ChipsFragment.newInstance()).addToBackStack("")
                    .commit()
            }
            android.R.id.home -> {
                BottomNavigationDrawerFragment().show(requireActivity().supportFragmentManager, "")
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}