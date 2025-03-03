package com.example.db_networks_patterns.flower_shop.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bouquets")
data class Bouquet(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String, // Например, "Букет для свадьбы"
    val price: Double // Цена букета
)
