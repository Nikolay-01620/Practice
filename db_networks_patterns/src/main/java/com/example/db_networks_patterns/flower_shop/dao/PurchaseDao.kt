package com.example.db_networks_patterns.flower_shop.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.db_networks_patterns.flower_shop.entity.Purchase

@Dao
interface PurchaseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPurchase(purchase: Purchase)

    @Query("SELECT * FROM purchases WHERE bouquetId = :bouquetId")
    suspend fun getPurchasesForBouquet(bouquetId: Long): List<Purchase>
}
