package com.example.practic.themes.sdk_4.interview_questions.handler

import android.os.Bundle
import android.os.Looper
import android.os.Message
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
        myHandler = MyHandler(Looper.getMainLooper(),this)

        // Кнопка для отправки сообщения
        binding.button.setOnClickListener {
            // Отправляем сообщение с кодом 1

            /** .obtain() это метод, который
             извлекает объект Message из пула сообщений*/
            val message = Message.obtain()
            message.what = 1
            myHandler.sendMessage(message)
        }
    }
}
