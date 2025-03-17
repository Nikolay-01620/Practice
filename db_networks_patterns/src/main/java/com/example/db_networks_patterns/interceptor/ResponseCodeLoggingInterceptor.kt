package com.example.db_networks_patterns.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import android.util.Log
import okhttp3.OkHttpClient

class ResponseCodeLoggingInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        Log.d("HTTP Response Code", "Response Code: ${response.code}")
        return response
    }
}

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(ResponseCodeLoggingInterceptor())
        .build()
}

