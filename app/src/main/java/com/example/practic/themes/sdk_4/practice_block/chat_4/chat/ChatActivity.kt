package com.example.practic.themes.sdk_4.practice_block.chat_4.chat

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practic.R
import com.example.practic.themes.sdk_4.practice_block.chat_4.message.Message
import com.example.practic.themes.sdk_4.practice_block.chat_4.message.MessageAdapter
import com.example.practic.themes.sdk_4.practice_block.chat_4.message.MessageDao

class ChatActivity : AppCompatActivity() {

    private lateinit var messageAdapter: MessageAdapter
    private lateinit var messageDao: MessageDao
    private lateinit var recyclerView: RecyclerView
    private lateinit var editText: EditText
    private lateinit var sendButton: Button
    private var chatId: String = ""

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sdk_activity_chat)

        recyclerView = findViewById(R.id.recyclerViewMessages)
        recyclerView.layoutManager = LinearLayoutManager(this)

        editText = findViewById(R.id.editTextMessage)
        sendButton = findViewById(R.id.sendMessageButton)

        chatId = intent.getStringExtra("CHAT_ID") ?: ""

        messageAdapter = MessageAdapter(emptyList())
        recyclerView.adapter = messageAdapter

        sendButton.setOnClickListener {
            val messageText = editText.text.toString()
            if (messageText.isNotEmpty()) {
                val message = Message(0, chatId, "User", messageText, System.currentTimeMillis())
                // Сохранить сообщение в Room
                // Также добавить логику для отправки сообщения через Firebase или WebSocket
            }
        }

        // Здесь будет код для получения сообщений из Room и отображения их
    }
}
