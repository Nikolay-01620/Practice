package com.example.practic.themes.sdk_4.interview_questions.handler

import android.os.Bundle
import android.os.Message
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.practic.databinding.HandlerActivityMainBinding

class HandlerActivity : AppCompatActivity() {

    // Создаем экземпляр Handler (через наш MyHandler)
    private lateinit var myHandler: MyHandler
    private lateinit var binding : HandlerActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HandlerActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Создаем Handler, связанный с главным потоком
        myHandler = MyHandler(Looper.getMainLooper(), this)

        // Кнопка для отправки сообщения немедленно
        binding.button.setOnClickListener {
            // Отправляем сообщение с кодом 1
            val message = myHandler.obtainMessage()
            message.what = 1
            myHandler.sendMessage(message)

            //myHandler.obtainMessage(1).sendToTarget()

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
            myHandler.postDelayed(runnable, 5000)
        }
    }
}
