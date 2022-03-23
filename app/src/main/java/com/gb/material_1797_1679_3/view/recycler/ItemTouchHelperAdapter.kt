package com.gb.material_1797_1679_3.view.recycler

interface ItemTouchHelperAdapter {
    fun onItemMove(fromPosition:Int,toPosition:Int)
    fun onItemDismiss(position:Int)
}

interface ItemTouchHelperViewHolder {
    fun onItemSelected()
    fun onItemClear()
}

