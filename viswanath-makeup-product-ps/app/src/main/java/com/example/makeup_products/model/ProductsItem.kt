package com.example.makeup_products.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "productItems")
data class ProductsItem(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = " price")
    val price: String,
    @ColumnInfo(name = " description")
    val description: String,
    @ColumnInfo(name = "image_link")
    val image_link: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(price)
        parcel.writeString(description)
        parcel.writeString(image_link)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ProductsItem> {
        override fun createFromParcel(parcel: Parcel): ProductsItem {
            return ProductsItem(parcel)
        }

        override fun newArray(size: Int): Array<ProductsItem?> {
            return arrayOfNulls(size)
        }
    }
}