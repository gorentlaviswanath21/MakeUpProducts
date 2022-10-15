package com.example.makeup_products.network

import androidx.lifecycle.LiveData
import com.example.makeup_products.model.Products
import com.example.makeup_products.model.ProductsItem
import com.example.makeup_products.roomdb.AppDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

// fetches the data from the serve
class RetroRepository
@Inject constructor(private val retroServiceInterface: RetroServiceInterface,
                   private val appDao: AppDao) {

    fun getAllProductItems() : LiveData<List<ProductsItem>> {
        return appDao.getAllItems()
    }

    fun insertProductItems(productsItem: ProductsItem) {
        appDao.insertProductItems(productsItem)
    }

    //get the data from MakeUp brand api

    fun makeApiCall(query: String) {
        val call: Call<Products> = retroServiceInterface.getDataFromAPI(query)
        call.enqueue(object : Callback<Products> {

            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                if (response.isSuccessful) {
                    appDao.deleteAllProductItems()
                    response.body()?.forEach {
                        insertProductItems(it)
                    }
                }
            }

            override fun onFailure(call: Call<Products>, t: Throwable) {

            }

        })
    }
}