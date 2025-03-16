package com.example.db_networks_patterns.flower_shop.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.db_networks_patterns.flower_shop.linking_classes.BouquetWithFlowers
import com.example.db_networks_patterns.flower_shop.entity.Bouquet


/** В этой таблице будет храниться информация о том,
какие букеты доступны, их состав (что в них входит и в каком количестве).*/
@Dao
interface BouquetDao {
    @Query("SELECT * FROM bouquets WHERE availableQuantity > 0")
    suspend fun getAllAvailableBouquets(): List<Bouquet>

    @Query("UPDATE bouquets SET availableQuantity = availableQuantity - 1 WHERE id = :bouquetId AND availableQuantity > 0")
    suspend fun updateBouquetQuantity(bouquetId: Long)
}

