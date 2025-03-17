package com.example.db_networks_patterns.flower_shop.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.db_networks_patterns.flower_shop.entity.Bouquet


@Dao
interface BouquetDao {
    @Query("SELECT * FROM bouquets WHERE availableQuantity > 0")
    suspend fun getAllAvailableBouquets(): List<Bouquet>

    @Query("UPDATE bouquets SET availableQuantity = availableQuantity - 1 WHERE bouquetId = :bouquetId AND availableQuantity > 0")
    suspend fun updateBouquetQuantity(bouquetId: Long)

}

