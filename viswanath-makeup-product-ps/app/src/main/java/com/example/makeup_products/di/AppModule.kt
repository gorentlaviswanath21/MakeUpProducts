package com.example.makeup_products.di

import android.content.Context
import com.example.makeup_products.network.RetroServiceInterface
import com.example.makeup_products.roomdb.AppDao
import com.example.makeup_products.roomdb.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    val BASE_URL = "https://makeup-api.herokuapp.com/api/v1/"//products.json?brand=maybelline

    @Provides
    @Singleton
    fun getAppDatabase(@ApplicationContext context: Context) : AppDatabase {
        return AppDatabase.getAppDBInstance(context)
    }

    @Provides
    @Singleton
    fun getAppDao(appDatabase: AppDatabase) : AppDao {
        return appDatabase.getAppDao()
    }

    @Provides
    @Singleton
     fun getRetroServiceInstance(retrofit: Retrofit):RetroServiceInterface{
         return retrofit.create(RetroServiceInterface::class.java)
     }

    @Provides
    @Singleton
    fun getRetroInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}