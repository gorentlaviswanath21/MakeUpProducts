package com.example.makeup_products.network

import com.example.makeup_products.di.AppModule
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    val retrofit :Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(AppModule().BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}