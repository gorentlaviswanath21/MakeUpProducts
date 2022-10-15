package com.example.makeup_products.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.makeup_products.R
import com.example.makeup_products.model.ProductsItem
import kotlinx.android.synthetic.main.card_view.view.*


class RecyclerViewAdapter(): RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    private  var listData : List<ProductsItem>? = null

    var onItemClick : ((ProductsItem) -> Unit)? = null

    fun setListData( listData : List<ProductsItem>?) {
        this.listData =listData
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType:Int
    ):RecyclerViewAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view,parent,false)
        return MyViewHolder(view)

    }

    override fun onBindViewHolder(
        holder: RecyclerViewAdapter.MyViewHolder,
        position:Int
    ) {
        val products = listData?.get(position)
        
        holder.bind(listData?.get(position)!!)
        holder.itemView.setOnClickListener {
            if (products != null) {
                onItemClick?.invoke(products)
            }
        }

    }

    override fun getItemCount(): Int {
        if (listData == null )return  0
        return  listData?.size!!
    }

        class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val imageView   = view.imageView    as ImageView
        private val brandTitle  = view.brand_title  as TextView
        private val priceView   = view.price_view   as TextView

        fun bind(data: ProductsItem){
            brandTitle.text = data.name
            priceView.text  = "$${data.price}"

            Glide.with(imageView)
                .load(data.image_link)
                .into(imageView)
        }
    }
}