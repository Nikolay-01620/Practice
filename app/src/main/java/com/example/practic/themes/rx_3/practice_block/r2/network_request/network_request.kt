package com.example.practic.themes.rx_3.practice_block.r2.network_request

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object NetworkUtils {

    fun fetchPost(callback: (Post?) -> Unit, onError: (String) -> Unit) {
        RetrofitClient.instance.getPost().enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful) {
                    callback(response.body())  // Возвращаем результат в callback
                } else {
                    onError("Ошибка: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                onError("Ошибка сети: ${t.message}")
            }
        })
    }
}
