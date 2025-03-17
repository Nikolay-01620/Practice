package com.example.db_networks_patterns.flower_shop

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.db_networks_patterns.flower_shop.dao.BouquetDao
import com.example.db_networks_patterns.flower_shop.dao.FlowerDao
import com.example.db_networks_patterns.flower_shop.entity.Bouquet
import com.example.db_networks_patterns.flower_shop.entity.BouquetFlower
import com.example.db_networks_patterns.flower_shop.entity.Flower

@Database(entities = [Flower::class, Bouquet::class, BouquetFlower::class], version = 2) // увеличиваем версию на 1
abstract class FlowerShopDatabase : RoomDatabase() {

    abstract fun flowerDao(): FlowerDao
    abstract fun bouquetDao(): BouquetDao

    companion object {
        private var database: RoomDatabase? = null

        fun createDatabase(context: Context): RoomDatabase {
            if (database == null) {
                synchronized(RoomDatabase::class.java) {
                    if (database == null) {
                        database = Room.databaseBuilder(
                            context.applicationContext,
                            FlowerShopDatabase::class.java, "flower_shop_db"
                        ).addMigrations(MIGRATION_1_2) 
                            .build()
                    }
                }
            }
            return database!!
        }
    }

}
