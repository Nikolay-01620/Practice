package com.example.practic.themes.rx_3.practice_block.task_2.network_request_1
import retrofit2.Call
import retrofit2.http.GET

    interface ApiService {
        @GET("posts/1") // Получаем пост с id 1
        fun getPost(): Call<Post>
    }
