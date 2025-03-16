package com.example.db_networks_patterns.flower_shop.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    tableName = "bouquet_flowers",
    foreignKeys = [
        ForeignKey(
            entity = Bouquet::class,
            parentColumns = ["bouquetId"],
            childColumns = ["bouquetId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Flower::class,
            parentColumns = ["flowerId"],
            childColumns = ["flowerId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class BouquetFlower(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val bouquetId: Long,
    val flowerId: Long,
    val quantity: Int
)
