package com.example.db_networks_patterns.flower_shop.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.db_networks_patterns.flower_shop.entity.BouquetFlower

@Dao
interface BouquetFlowerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBouquetFlower(bouquetFlower: BouquetFlower)

    @Query("SELECT * FROM bouquet_flowers WHERE bouquetId = :bouquetId")
    suspend fun getFlowersInBouquet(bouquetId: Long): List<BouquetFlower>
}
