package com.example.makeup_products

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.example.makeup_products.adapter.RecyclerViewAdapter
import com.example.makeup_products.model.ProductsItem
import com.example.makeup_products.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewAdapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModel()
        initMainViewModel()

    }

    private fun initViewModel() {
        recycleView.apply {
            layoutManager = GridLayoutManager(applicationContext,2)

            val decoration = DividerItemDecoration(applicationContext,DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            recyclerViewAdapter = RecyclerViewAdapter()
            adapter = recyclerViewAdapter

            recyclerViewAdapter.onItemClick = {
                val intent = Intent(this@MainActivity,DetailScreenActivity::class.java)
                intent.putExtra("products",it)
                startActivity(intent)

            }


        }
    }

    private fun initMainViewModel() {
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getAllProducts().observe(this, Observer<List<ProductsItem>> {
            recyclerViewAdapter.setListData(it)
            recyclerViewAdapter.notifyDataSetChanged()


        })

        viewModel.makeApiCall()
    }
}