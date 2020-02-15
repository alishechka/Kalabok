package com.example.kalabok.network

import com.example.kalabok.BASE_URL
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object MealRetrofitClient {

    private val retrofitInstance by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    val mealClient: MealClient by lazy {
        retrofitInstance.create(MealClient::class.java)
    }
}