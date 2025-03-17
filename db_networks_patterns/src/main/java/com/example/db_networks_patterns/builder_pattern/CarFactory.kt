package com.example.db_networks_patterns.builder_pattern

interface CarFactory {
    fun createCar(): Car
}

class SportsCarFactory : CarFactory {
    override fun createCar(): Car {
        return CarBuilder()
            .setBrand("Ferrari")
            .setModel("488")
            .setColor("Red")
            .build()!!
    }
}

class SedanCarFactory : CarFactory {
    override fun createCar(): Car {
        return CarBuilder()
            .setBrand("Mercedes")
            .setModel("S-Class")
            .setColor("White")
            .build()!!
    }
}
