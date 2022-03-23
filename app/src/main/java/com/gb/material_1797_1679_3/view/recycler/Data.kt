package com.gb.material_1797_1679_3.view.recycler


const val TYPE_EARTH =1
const val TYPE_MARS =2
const val TYPE_TITLE =3

data class Data(val name:String="Text",val description:String?=null,val type:Int=TYPE_EARTH)