package com.example.practic.themes.sdk_4.practice_block.chat_4.chat

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ChatDao {
    @Insert
    suspend fun insert(chat: Chat)

    @Query("SELECT * FROM chats")
    suspend fun getAllChats(): List<Chat>
}
