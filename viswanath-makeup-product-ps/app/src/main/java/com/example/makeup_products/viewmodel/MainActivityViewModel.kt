package com.example.makeup_products.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.makeup_products.model.ProductsItem
import com.example.makeup_products.network.RetroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

// we have to receive the dependency..
@HiltViewModel
class MainActivityViewModel
@Inject constructor(private val repository: RetroRepository) : ViewModel() {

    fun getAllProducts() : LiveData<List<ProductsItem>> {
        return  repository.getAllProductItems()
    }

    fun makeApiCall() {
        repository.makeApiCall("maybelline")
    }
}