package com.example.db_networks_patterns.flower_shop.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.db_networks_patterns.flower_shop.entity.Flower

@Dao
interface FlowerDao {
    // Метод для обновления количества цветков в базе данных
    @Query("UPDATE flowers SET availableQuantity = availableQuantity - :quantity WHERE id = :flowerId")
    suspend fun updateFlowerQuantity(flowerId: Long, quantity: Int)

    // Метод для удаления цветка, если его количество стало нулевым или меньше
    @Query("DELETE FROM flowers WHERE id = :flowerId AND availableQuantity <= 0")
    suspend fun deleteFlower(flowerId: Long)
}

