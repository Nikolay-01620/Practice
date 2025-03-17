package com.example.db_networks_patterns.flower_shop.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "flowers")
data class Flower(
    @PrimaryKey(autoGenerate = true) val flowerId: Long = 0,
    val name: String,
    val color: String,
    val availableQuantity: Int,
    val countryOfOrigin: String? = null
)
