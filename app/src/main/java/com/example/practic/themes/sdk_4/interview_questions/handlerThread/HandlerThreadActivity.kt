package com.example.practic.themes.sdk_4.interview_questions.handlerThread

import android.os.Bundle
import android.os.HandlerThread
import android.os.Message
import androidx.appcompat.app.AppCompatActivity
import com.example.practic.databinding.HandlerActivityMainBinding

class HandlerThreadActivity : AppCompatActivity() {

    private lateinit var handlerThread: HandlerThread
    private lateinit var myHandler: MyHandler
    private lateinit var binding: HandlerActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HandlerActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Создаем HandlerThread и запускаем его
        handlerThread = HandlerThread("MyHandlerThread")
        handlerThread.start()

        // Создаем Handler, который использует Looper из HandlerThread
        myHandler = MyHandler(handlerThread.looper, this)

        // Кнопка для отправки сообщения немедленно
        binding.button.setOnClickListener {
            // Отправляем сообщение с кодом 1
            val message = Message.obtain()
            message.what = 1
            myHandler.sendMessage(message)
        }

        // Кнопка для отправки сообщения с задержкой
        binding.buttonDelayed.setOnClickListener {
            // Отправляем сообщение с задержкой через Runnable
            val runnable = Runnable {
                val message = Message.obtain()
                message.what = 2
                myHandler.sendMessage(message)
            }
            // Отправляем Runnable через Handler с задержкой (2 секунды)
            myHandler.postDelayed(runnable, 2000)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Останавливаем HandlerThread при уничтожении Activity
        handlerThread.quitSafely()
    }
}