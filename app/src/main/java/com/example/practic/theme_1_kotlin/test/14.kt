package com.example.practic.theme_1_kotlin.test

// Инвариантный интерфейс

/** InvariantProvider<T>: Этот интерфейс инвариантен,
так как он использует тип T без каких-либо аннотаций.
Это значит, что InvariantProvider<Dog> и
InvariantProvider<Animal> — это разные типы.*/

interface InvariantProvider<T> {
    fun get(): T
}


// Контравариантный интерфейс

/** ContravariantProvider<in T>: Этот интерфейс контравариантен
из-за аннотации in. Это позволяет использовать
ContravariantProvider<Animal> везде, где ожидается
ContravariantProvider<Dog>, если Dog является подтипом Animal.
Метод get() возвращает значение с аннотацией @UnsafeVariance,
что позволяет использовать его как ковариантный тип.*/

interface ContravariantProvider<in T> {
    fun get(): @UnsafeVariance T
}


// Ковариантный интерфейс

/** Ковариантный интерфейс:
Можно заменить класс-наследник на суперкласс.*/

interface CovariantProvider<out T> {
    fun get(): T
}
