package com.example.db_networks_patterns.flower_shop.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "purchases")
data class Purchase(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val bouquetId: Long,
    val quantity: Int, // Сколько раз букет был куплен
    val purchaseDate: Long // Время покупки (timestamp)
)
