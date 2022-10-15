package com.example.makeup_products.roomdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.makeup_products.model.ProductsItem

@Dao
interface AppDao {

    @Query("SELECT * FROM productItems")
    fun getAllItems() : LiveData<List<ProductsItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProductItems(productsItem: ProductsItem)

    @Query("DELETE FROM productItems")
    fun deleteAllProductItems()
}