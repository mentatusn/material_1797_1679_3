package com.gb.material_1797_1679_3.view.recycler

import androidx.recyclerview.widget.RecyclerView

fun interface OnClickItemListener {
    fun onItemClick(data: Data)
}

fun interface OnStartDragListener {
    fun onStartDrag(view:RecyclerView.ViewHolder)
}