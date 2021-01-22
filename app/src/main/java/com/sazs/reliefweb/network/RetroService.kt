package com.sazs.reliefweb.network

import com.sazs.reliefweb.RecyclerList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    @GET("disasters?appname=sazs")
    fun getDataFromAPI(@Query("query[value]")query: String): Call<RecyclerList>

}