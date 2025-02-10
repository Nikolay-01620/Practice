package com.example.practic.themes.sdk_4.practice_block.chat_4
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practic.R
import com.example.practic.themes.sdk_4.practice_block.chat_4.chat.ChatActivity
import com.example.practic.themes.sdk_4.practice_block.chat_4.chat.ChatAdapter
import com.example.practic.themes.sdk_4.practice_block.chat_4.chat.ChatDao

class ChatListActivity : AppCompatActivity() {

    private lateinit var chatAdapter: ChatAdapter
    private lateinit var chatDao: ChatDao
    private lateinit var recyclerView: RecyclerView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sdk_activity_chat_list)

        recyclerView = findViewById(R.id.recyclerViewChats)
        recyclerView.layoutManager = LinearLayoutManager(this)

        chatAdapter = ChatAdapter(emptyList()) { chat ->
            val intent = Intent(this, ChatActivity::class.java)
            intent.putExtra("CHAT_ID", chat.chatId)
            startActivity(intent)
        }
        recyclerView.adapter = chatAdapter

        // Здесь будет код для получения данных из Room и отображения чатов
    }
}
