package com.sazs.reliefweb

data class RecyclerList(val data: ArrayList<RecyclerData>)
data class RecyclerData(val href: String, val fields: Fields)
data class Fields(val name: String, val date: List<Date>)
data class Date(val created: String)