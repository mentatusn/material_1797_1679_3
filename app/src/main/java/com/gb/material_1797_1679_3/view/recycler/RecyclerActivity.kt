package com.gb.material_1797_1679_3.view.recycler

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gb.material_1797_1679_3.R
import com.gb.material_1797_1679_3.databinding.ActivityRecyclerBinding
import com.gb.material_1797_1679_3.view.main.PictureOfTheDayFragment

class RecyclerActivity : AppCompatActivity() {

    lateinit var binding: ActivityRecyclerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.MyBlueTheme)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val lat = 20
        val lon = 23
        val time = 23

        val myCoordinate1 = lat to lon
        myCoordinate1.first// то же самое что и lat
        myCoordinate1.second// то же самое что и lon

        val myCoordinate2 = Pair(lat, lon)
        myCoordinate2.first// то же самое что и lat
        myCoordinate2.second// то же самое что и lon

        val myCoordinate3 = Triple(lat, lon, time)
        myCoordinate3.first// то же самое что и lat
        myCoordinate3.second// то же самое что и lon
        myCoordinate3.third// то же самое что и time


        val listData = arrayListOf(
            Pair(Data(getString(R.string.earth), "Дополнительный текст"), false),
            Pair(Data(getString(R.string.earth), "Дополнительный текст"), false),
            Pair(Data(getString(R.string.mars), type = TYPE_MARS), false),
            Pair(Data(getString(R.string.mars), type = TYPE_MARS), false),
        )
        listData.shuffle()
        listData.add(0, Pair(Data(getString(R.string.header), type = TYPE_HEADER), false))
        val adapter = RecyclerActivityAdapter(object : OnClickItemListener {
            override fun onItemClick(data: Data) {
                Toast.makeText(this@RecyclerActivity, "Мы супер ${data.name}", Toast.LENGTH_SHORT)
                    .show()
            }
        })
        adapter.setData(listData)
        binding.recyclerView.adapter = adapter
        binding.recyclerActivityFAB.setOnClickListener {
            adapter.appendItem()
            //binding.recyclerView.smoothScrollToPosition(adapter.itemCount)
        }
    }

}