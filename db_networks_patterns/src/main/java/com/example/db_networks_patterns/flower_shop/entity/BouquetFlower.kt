package com.example.db_networks_patterns.flower_shop.entity

import androidx.room.Entity
import androidx.room.ForeignKey



/** 2. primaryKeys = ["bouquetId", "flowerId"]
Этот параметр указывает составной первичный ключ для таблицы.
В базе данных может быть только один первичный ключ, но он может быть составным,
то есть из нескольких колонок. В данном случае, это составной ключ из двух колонок:

bouquetId

flowerId

Это означает, что каждая строка в таблице bouquet_flowers будет уникальной в
контексте конкретного букета и конкретного цветка. Таким образом,
для одного букета можно хранить несколько записей с разными цветами,
а для одного цветка — несколько записей в разных букета.
Но комбинация этих двух значений должна быть уникальной
в каждой строке таблицы.*/


@Entity(
    tableName = "bouquet_flowers",
    primaryKeys = ["bouquetId", "flowerId"],
    foreignKeys = [
        ForeignKey(entity = Bouquet::class, parentColumns = ["id"], childColumns = ["bouquetId"]),
        ForeignKey(entity = Flower::class, parentColumns = ["id"], childColumns = ["flowerId"])
    ]
)
data class BouquetFlower(
    val bouquetId: Long, // это ссылка на конкретный букет
    val flowerId: Long, // это ссылка на цветок, который входит в букет.
    val quantity: Int // Количество цветков определенного типа в букете
)
