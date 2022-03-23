package com.gb.material_1797_1679_3.view.recycler

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gb.material_1797_1679_3.R
import com.gb.material_1797_1679_3.databinding.ActivityRecyclerBinding
import com.gb.material_1797_1679_3.view.main.PictureOfTheDayFragment

class RecyclerActivity : AppCompatActivity() {

    lateinit var binding:ActivityRecyclerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.MyBlueTheme)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = arrayListOf(
            Data(getString(R.string.earth), "Дополнительный текст"),
            Data(getString(R.string.earth), "Дополнительный текст"),
            Data(getString(R.string.earth), "Дополнительный текст"),
            Data(getString(R.string.earth), "Дополнительный текст"),
            Data(getString(R.string.mars), type=TYPE_MARS),
            Data(getString(R.string.mars), type=TYPE_MARS),
            Data(getString(R.string.mars), type=TYPE_MARS),
            Data(getString(R.string.mars), type=TYPE_MARS),
        )
        data.shuffle()
        val adapter = RecyclerActivityAdapter(object :OnClickItemListener{
            override fun onItemClick(data: Data) {
                Toast.makeText(this@RecyclerActivity,"Мы супер ${data.name}",Toast.LENGTH_SHORT).show()
            }
        })
        adapter.setData(data)
        binding.recyclerView.adapter = adapter
    }

}