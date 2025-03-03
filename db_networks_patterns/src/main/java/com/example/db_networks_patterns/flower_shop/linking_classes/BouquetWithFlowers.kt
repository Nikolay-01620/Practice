package com.example.db_networks_patterns.flower_shop.linking_classes

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.db_networks_patterns.flower_shop.entity.Bouquet
import com.example.db_networks_patterns.flower_shop.entity.BouquetFlower
import com.example.db_networks_patterns.flower_shop.entity.Flower

data class BouquetWithFlowers(
    @Embedded val bouquet: Bouquet,
    @Relation(
        parentColumn = "id",
        entityColumn = "flowerId",
        associateBy = Junction(BouquetFlower::class)
    )
    val flowers: List<FlowerWithQuantity>
)

data class FlowerWithQuantity(
    @Embedded val flower: Flower,
    val quantity: Int
)
