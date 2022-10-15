package com.example.makeup_products.network


import com.example.makeup_products.di.AppModule
import org.junit.Test
import retrofit2.Retrofit

class RetrofitClientTest {

    @Test
    fun testRetroInstance(){
        val instance : Retrofit = RetrofitClient().retrofit
        assert(instance.baseUrl().toString()==AppModule().BASE_URL)
    }

    @Test
    fun testMakeUpService(){
        val service = MakeUpService(RetrofitClient().retrofit)
        val response = service.getDataFromAPI("brand").execute()
        val errorBody = response.errorBody()
        assert(errorBody == null)

        val response2 = response.body()
        assert(response2 != null)
        assert(response.code() ==200)
    }
}