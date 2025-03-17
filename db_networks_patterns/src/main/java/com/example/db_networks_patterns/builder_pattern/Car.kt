package com.example.db_networks_patterns.builder_pattern

/** Product — это сам объект, который строится */
class Car(
    val brand: String,
    val model: String,
    val color: String,
) {
    override fun toString(): String {
        return "Car(chassis='$brand', paint='$color', interior='$model')"
    }

}

/** Конкретная реализация Builder, которая строит объект с конкретными деталями.*/
class CarBuilder {
    private var brand = ""
    private var model = ""
    private var color = ""

    fun setBrand(brand: String) = apply { this.brand = brand }
    fun setModel(model: String) = apply { this.model = model }
    fun setColor(color: String) = apply { this.color = color }


    fun build(): Car? {
        if (brand.isNotEmpty() && model.isNotEmpty() && color.isNotEmpty()) {
            return Car(brand, model, color)
        }
        return null
    }
}

fun main() {
    
    val car = CarBuilder()
        .setBrand("Mercedes")
        .setModel("E-Class")
        .setColor("Black")
        .build()

    if (car != null) {
        println("Car assembled: $car")
    } else {
        println("Car assembly failed")
    }
}
