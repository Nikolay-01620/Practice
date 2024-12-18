package com.example.practic.interview_questions

interface Animal {

    val value: Int

    fun sound()  // Объявление без реализации

    fun sleep() {  // Метод с реализацией по умолчанию
        println("The animal is sleeping.")
    }
}

abstract class Mammal {

    val value2 = 6
    abstract val value3: Int

    abstract fun sound()  // Абстрактный метод без реализации

    fun breathe() {  // Метод с реализацией
        println("The mammal is breathing : $value2.")
    }
}

class Dog : Animal, Mammal() {

    override val value: Int
        get() = TODO("Not yet implemented")

    override val value3: Int
        get() = TODO("Not yet implemented")

    override fun sound() {
        println("Bark")
    }
}

fun main() {
    val dog = Dog()
    dog.sound()
    dog.sleep()
    dog.breathe()
}
