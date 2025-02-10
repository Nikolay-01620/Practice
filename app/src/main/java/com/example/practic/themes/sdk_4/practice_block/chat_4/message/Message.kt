package com.example.practic.themes.sdk_4.practice_block.chat_4.message

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "messages")
data class Message(
    @PrimaryKey(autoGenerate = true) val messageId: Int,
    val chatId: String,
    val sender: String,
    val messageText: String,
    val timestamp: Long
)
