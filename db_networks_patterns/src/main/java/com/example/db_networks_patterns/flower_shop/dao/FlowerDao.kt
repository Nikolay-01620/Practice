package com.example.db_networks_patterns.flower_shop.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.db_networks_patterns.flower_shop.entity.Flower

@Dao
interface FlowerDao {

    @Query("UPDATE flowers SET availableQuantity = availableQuantity - :quantity WHERE flowerId = :flowerId")
    suspend fun updateFlowerQuantity(flowerId: Long, quantity: Int)

    @Query("DELETE FROM flowers WHERE flowerId = :flowerId AND availableQuantity <= 0")
    suspend fun deleteFlower(flowerId: Long)
}

