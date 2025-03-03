package com.example.db_networks_patterns.flower_shop.dao
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.db_networks_patterns.flower_shop.linking_classes.BouquetWithFlowers
import com.example.db_networks_patterns.flower_shop.entity.Bouquet

@Dao
interface BouquetDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBouquet(bouquet: Bouquet)

    @Query("SELECT * FROM bouquets")
    suspend fun getAllBouquets(): List<Bouquet>

    @Transaction
    @Query("SELECT * FROM bouquets WHERE id = :bouquetId")
    suspend fun getBouquetWithFlowers(bouquetId: Long): List<BouquetWithFlowers>
}
