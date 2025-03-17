package com.example.db_networks_patterns.flower_shop

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(db: SupportSQLiteDatabase) {
        // 1. Добавляем новое поле "оформление" в таблицу bouquets
        db.execSQL("ALTER TABLE bouquets ADD COLUMN `design` TEXT")

        // 2. Добавляем новое поле "страна-производитель" в таблицу flowers
        db.execSQL("ALTER TABLE flowers ADD COLUMN `country_of_origin` TEXT")
    }
}