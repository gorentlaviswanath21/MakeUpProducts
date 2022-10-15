package com.example.makeup_products.network

import com.example.makeup_products.model.Products
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface EndPointMakeUpProduct {

    @GET("products.json")
    fun getDataFromAPI(@Query("brand")query: String): Call<Products>
}