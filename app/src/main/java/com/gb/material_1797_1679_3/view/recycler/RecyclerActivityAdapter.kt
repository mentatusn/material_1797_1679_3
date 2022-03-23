package com.gb.material_1797_1679_3.view.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gb.material_1797_1679_3.R
import com.gb.material_1797_1679_3.databinding.ActivityRecyclerItemEarthBinding
import com.gb.material_1797_1679_3.databinding.ActivityRecyclerItemHeaderBinding
import com.gb.material_1797_1679_3.databinding.ActivityRecyclerItemMarsBinding

class RecyclerActivityAdapter(val onClickItemListener:OnClickItemListener):RecyclerView.Adapter<RecyclerActivityAdapter.BaseViewHolder>() {
    private lateinit var listData: MutableList<Data>
    fun setData(listData:MutableList<Data>){
        this.listData = listData
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when(viewType){
            TYPE_EARTH -> {
                val binding = ActivityRecyclerItemEarthBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                EarthViewHolder(binding.root)
            }
            TYPE_HEADER-> {
                val binding = ActivityRecyclerItemHeaderBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                HeaderViewHolder(binding.root)
            }
            else-> {
                val binding = ActivityRecyclerItemMarsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                MarsViewHolder(binding.root)
            }
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemViewType(position: Int): Int {
        return listData[position].type
    }

    override fun getItemCount()=listData.size

    fun appendItem() {
        listData.add(generateData())
        //notifyDataSetChanged()
        notifyItemInserted(listData.size-1)
    }
    fun generateData() = Data("Mars", type=TYPE_MARS)

    inner class MarsViewHolder(view:View):BaseViewHolder(view){
        override fun bind(data: Data){
            ActivityRecyclerItemMarsBinding.bind(itemView).apply {
                tvName.text = data.name
                ivMars.setOnClickListener {
                    onClickItemListener.onItemClick(data)
                }
                addItemImageView.setOnClickListener {
                    listData.add(layoutPosition,generateData())
                    notifyItemInserted(layoutPosition)
                }
                removeItemImageView.setOnClickListener {
                    listData.removeAt(layoutPosition)
                    notifyItemRemoved(layoutPosition)
                }
                moveItemUp.setOnClickListener {
                    // TODO HW java.lang.IndexOutOfBoundsException +Header не трогаем
                    listData.removeAt(layoutPosition).apply {
                        listData.add(layoutPosition-1,this)
                    }
                    notifyItemMoved(layoutPosition,layoutPosition-1)
                }
                moveItemDown.setOnClickListener {
                    // TODO HW java.lang.IndexOutOfBoundsException
                    listData.removeAt(layoutPosition).apply {
                        listData.add(layoutPosition+1,this)
                    }
                    notifyItemMoved(layoutPosition,layoutPosition+1)
                }
            }
        }
    }




    abstract class BaseViewHolder(view:View):RecyclerView.ViewHolder(view){
        abstract fun bind(data: Data)
    }

    inner class EarthViewHolder(view:View):BaseViewHolder(view){
        override fun bind(data: Data){
            ActivityRecyclerItemEarthBinding.bind(itemView).apply {
                tvName.text = data.name
                tvDescription.text = data.description
                ivEarth.setOnClickListener {
                    onClickItemListener.onItemClick(data)
                }
            }
        }
    }



    inner class HeaderViewHolder(view:View):BaseViewHolder(view){
        override fun bind(data: Data){
            ActivityRecyclerItemHeaderBinding.bind(itemView).apply {
                tvName.text = data.name
                itemView.setOnClickListener {
                    onClickItemListener.onItemClick(data)
                }
            }
        }
    }


}