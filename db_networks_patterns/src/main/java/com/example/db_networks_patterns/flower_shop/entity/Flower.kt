package com.example.db_networks_patterns.flower_shop.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/** Класс-сущность для оддного цветка. */

@Entity(tableName = "flowers")
data class Flower(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val color: String, // Например, "белый", "красный"
    val price: Double, // Цена одного цветка
    val availableQuantity: Int // Доступное количество цветов в магазине.

)
