package com.example.makeup_products.network

import com.example.makeup_products.model.Products
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.create

class MakeUpService constructor(private val retrofit: Retrofit):EndPointMakeUpProduct{

    private val endPoint by lazy { retrofit.create(EndPointMakeUpProduct::class.java) }

    override fun getDataFromAPI(query: String): Call<Products> {
        return endPoint.getDataFromAPI("brand")
    }


}