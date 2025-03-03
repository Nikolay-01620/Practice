package com.example.db_networks_patterns.flower_shop.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.db_networks_patterns.flower_shop.entity.Flower

@Dao
interface FlowerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFlower(flower: Flower)

    @Query("SELECT * FROM flowers WHERE id = :flowerId")
    suspend fun getFlowerById(flowerId: Long): Flower?

    @Query("UPDATE flowers SET availableQuantity = availableQuantity - :quantity WHERE id = :flowerId")
    suspend fun updateFlowerQuantity(flowerId: Long, quantity: Int)
    
    @Query("SELECT * FROM flowers")
    suspend fun getAllFlowers(): List<Flower>
}
