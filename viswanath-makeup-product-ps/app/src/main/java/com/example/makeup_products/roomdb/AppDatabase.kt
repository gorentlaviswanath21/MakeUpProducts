package com.example.makeup_products.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.makeup_products.model.ProductsItem


@Database(entities = [ProductsItem::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getAppDao() : AppDao

    companion object{
        private var DB_INSTANCE :AppDatabase? =null

        fun getAppDBInstance(context: Context) : AppDatabase{
            if(DB_INSTANCE == null){
                DB_INSTANCE = Room.databaseBuilder(context.applicationContext,AppDatabase::class.java,"MakeUp_DB")
                    .allowMainThreadQueries()
                    .build()

            }
            return DB_INSTANCE!!
        }
    }
}