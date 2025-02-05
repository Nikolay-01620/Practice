package com.example.practic.themes.rx_3.practice_block.tasks_2.network_request_1

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    val instance: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) // Для работы с JSON
            .build()

        retrofit.create(ApiService::class.java)
    }
}
