package com.sazs.reliefweb.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {
    companion object {
        val baseURL = "https://api.reliefweb.int/v1/"
        fun getRetroInstance(): Retrofit {
            return Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
    }
}