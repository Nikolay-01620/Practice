package com.example.practic.themes.sdk_4.interview_questions.handler

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.widget.Toast

class MyHandler(looper: Looper, val context: Context) : Handler() {

    /** это метод, который переопределен для обработки входящих*/
    override fun handleMessage(msg: Message) {
        super.handleMessage(msg)

        // Здесь будет ваша логика для обработки сообщений
        when (msg.what) {
            1 -> {
                // Например, если сообщение с кодом 1, выводим Toast
                Toast.makeText(context, "Received Message 1", Toast.LENGTH_SHORT).show()
            }

            2 -> {
                // Сообщение с кодом 2 — Toast с задержкой
                Toast.makeText(context, "Received Message 2 (Delayed)", Toast.LENGTH_SHORT).show()
            }

            else -> {
                // Если сообщение с другим кодом, игнорируем
                Log.d("MyHandler", "Unknown message")
            }
        }
    }
}
