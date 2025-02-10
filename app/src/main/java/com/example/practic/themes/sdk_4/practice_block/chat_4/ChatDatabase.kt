package com.example.practic.themes.sdk_4.practice_block.chat_4

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.practic.themes.sdk_4.practice_block.chat_4.chat.Chat
import com.example.practic.themes.sdk_4.practice_block.chat_4.chat.ChatDao
import com.example.practic.themes.sdk_4.practice_block.chat_4.message.Message
import com.example.practic.themes.sdk_4.practice_block.chat_4.message.MessageDao

@Database(entities = [Chat::class, Message::class], version = 1)
abstract class ChatDatabase : RoomDatabase() {
    abstract fun chatDao(): ChatDao
    abstract fun messageDao(): MessageDao
}
