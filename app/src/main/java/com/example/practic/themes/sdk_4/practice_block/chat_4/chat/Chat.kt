package com.example.practic.themes.sdk_4.practice_block.chat_4.chat

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "chats")
data class Chat(
    @PrimaryKey val chatId: String,
    val chatName: String,
    val lastMessage: String
)
