package com.example.db_networks_patterns.flower_shop

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.db_networks_patterns.flower_shop.dao.BouquetDao
import com.example.db_networks_patterns.flower_shop.dao.BouquetFlowerDao
import com.example.db_networks_patterns.flower_shop.dao.FlowerDao
import com.example.db_networks_patterns.flower_shop.dao.PurchaseDao
import com.example.db_networks_patterns.flower_shop.entity.Bouquet
import com.example.db_networks_patterns.flower_shop.entity.BouquetFlower
import com.example.db_networks_patterns.flower_shop.entity.Flower
import com.example.db_networks_patterns.flower_shop.entity.Purchase

@Database(entities = [Flower::class, Bouquet::class, BouquetFlower::class, Purchase::class], version = 1)
abstract class FlowerShopDatabase : RoomDatabase() {
    abstract fun flowerDao(): FlowerDao
    abstract fun bouquetDao(): BouquetDao
    abstract fun bouquetFlowerDao(): BouquetFlowerDao
    abstract fun purchaseDao(): PurchaseDao




}
