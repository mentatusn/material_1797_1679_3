package com.gb.material_1797_1679_3.view.recycler

import android.renderscript.Element
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gb.material_1797_1679_3.databinding.ActivityRecyclerItemEarthBinding
import com.gb.material_1797_1679_3.databinding.ActivityRecyclerItemMarsBinding

class RecyclerActivityAdapter(val onClickItemListener:OnClickItemListener):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    lateinit var listData: List<Data>
    fun setData(listData:List<Data>){
        this.listData = listData
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            TYPE_EARTH -> {
                val binding = ActivityRecyclerItemEarthBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                EarthViewHolder(binding.root)
            }
            else-> {
                val binding = ActivityRecyclerItemMarsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                MarsViewHolder(binding.root)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(getItemViewType(position)){
            TYPE_EARTH -> {
                (holder as EarthViewHolder).bind(listData[position])
            }
            else-> {
                (holder as MarsViewHolder).bind(listData[position])
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return listData[position].type
    }

    override fun getItemCount()=listData.size


    inner class EarthViewHolder(view:View):RecyclerView.ViewHolder(view){
        fun bind(data: Data){
            ActivityRecyclerItemEarthBinding.bind(itemView).apply {
                tvName.text = data.name
                tvDescription.text = data.description
                ivEarth.setOnClickListener {
                    onClickItemListener.onItemClick(data)
                }
            }
        }
    }

    inner class MarsViewHolder(view:View):RecyclerView.ViewHolder(view){
        fun bind(data: Data){
            ActivityRecyclerItemMarsBinding.bind(itemView).apply {
                tvName.text = data.name
                ivMars.setOnClickListener {
                    onClickItemListener.onItemClick(data)
                }
            }
        }
    }


}