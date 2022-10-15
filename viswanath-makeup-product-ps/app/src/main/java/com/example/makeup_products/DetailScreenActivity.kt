package com.example.makeup_products

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.makeup_products.model.ProductsItem

class DetailScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_screen)

        val products = intent.getParcelableExtra<ProductsItem>("products")
        if ( products != null ) {
            val makeUpImageView = findViewById<ImageView>(R.id.makeUpImageView)
            val titleTextView = findViewById<TextView>(R.id.titleTextView)
            val descriptionText = findViewById<TextView>(R.id.descriptionText)

            titleTextView.text   = products.name
            descriptionText.text = products.description

            Glide.with(this)
                .load(products.image_link)
                .into(makeUpImageView)

        }

    }
}