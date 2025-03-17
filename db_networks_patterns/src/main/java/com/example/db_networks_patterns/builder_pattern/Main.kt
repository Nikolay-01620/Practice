package com.example.db_networks_patterns.builder_pattern


fun main() {

    val sportsCarFactory: CarFactory = SportsCarFactory()
    val sportsCar = sportsCarFactory.createCar()
    println("Created: $sportsCar")

    val sedanCarFactory: CarFactory = SedanCarFactory()
    val sedanCar = sedanCarFactory.createCar()
    println("Created: $sedanCar")

}
