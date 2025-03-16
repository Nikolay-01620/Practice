package com.example.db_networks_patterns.flower_shop

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.db_networks_patterns.flower_shop.dao.BouquetDao
import com.example.db_networks_patterns.flower_shop.dao.FlowerDao
import com.example.db_networks_patterns.flower_shop.entity.Bouquet
import com.example.db_networks_patterns.flower_shop.entity.BouquetFlower
import com.example.db_networks_patterns.flower_shop.entity.Flower

@Database(entities = [Flower::class, Bouquet::class, BouquetFlower::class], version = 1)
abstract class FlowerShopDatabase : RoomDatabase() {

    abstract fun flowerDao(): FlowerDao
    abstract fun bouquetDao(): BouquetDao


    // Тут создаем БД

}
