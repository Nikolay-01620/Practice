package com.example.db_networks_patterns.interceptor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import com.example.db_networks_patterns.R
import okhttp3.OkHttpClient
import okhttp3.Request
import com.example.db_networks_patterns.interceptor.ResponseCodeLoggingInterceptor

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.interceptor_activity_main)

        val client = provideOkHttpClient()

        val request = Request.Builder()
            .url("https://jsonplaceholder.typicode.com/posts")
            .build()

        client.newCall(request).execute().use { response ->
            Log.d("HTTP Response", "Response Body: ${response.body?.string()}")
        }
    }
}
