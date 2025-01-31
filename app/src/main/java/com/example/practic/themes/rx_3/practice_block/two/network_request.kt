package com.example.practic.themes.rx_3.practice_block.two

import com.example.practic.themes.rx_3.practice_block.two.network_request.Post
import com.example.practic.themes.rx_3.practice_block.two.network_request.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun main() {
    // Выполняем запрос с использованием Retrofit
    RetrofitClient.instance.getPost().enqueue(object : Callback<Post> {
        override fun onResponse(call: Call<Post>, response: Response<Post>) {
            if (response.isSuccessful) {
                val post = response.body()
                // Если запрос успешен, выводим результат
                println("""
                    User ID: ${post?.userId}
                    Post ID: ${post?.id}
                    Title: ${post?.title}
                    Body: ${post?.body}
                """.trimIndent())
            } else {
                println("Ошибка: ${response.code()}")
            }
        }

        override fun onFailure(call: Call<Post>, t: Throwable) {
            // Если произошла ошибка, выводим ее
            println("Ошибка сети: ${t.message}")
        }
    })
}
