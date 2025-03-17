package com.example.practic.themes.sdk_4.interview_questions.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

// MyService.kt
class MyService : Service() {

    override fun onCreate() {
        super.onCreate()
        // Сервис создается
        Log.d("MyService", "Сервис создан")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Получаем переданные данные из Intent
        val fileUrl = intent?.getStringExtra("file_url")

        // Логируем полученные данные
        Log.d("MyService", "Получен URL для скачивания: $fileUrl")

        // Выполняем долгую задачу (например, скачивание файла)
        downloadFile(fileUrl)

        // Возвращаем значение, которое говорит системе, что сервис продолжает работу
        return START_STICKY
    }

    private fun downloadFile(url: String?) {
        // Здесь будет логика для скачивания файла (например, с использованием OkHttp или другого подхода)
        Log.d("MyService", "Начинаем скачивание файла с URL: $url")
    }

    override fun onDestroy() {
        super.onDestroy()
        // Завершаем сервис
        Log.d("MyService", "Сервис завершен")
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }


}
