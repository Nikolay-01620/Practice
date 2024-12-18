package com.example.practic.theme_1_kotlin.test

// Инвариантный интерфейс

/** InvariantProvider<T>: Этот интерфейс инвариантен,
так как он использует тип T без каких-либо аннотаций.
Это значит, что InvariantProvider<com.example.practic.interview_questions.Dog> и
InvariantProvider<com.example.practic.interview_questions.Animal> — это разные типы.*/

interface InvariantProvider<T> {
    fun get(): T
}


// Контравариантный интерфейс

/** ContravariantProvider<in T>: Этот интерфейс контравариантен
из-за аннотации in. Это позволяет использовать
ContravariantProvider<com.example.practic.interview_questions.Animal> везде, где ожидается
ContravariantProvider<com.example.practic.interview_questions.Dog>, если com.example.practic.interview_questions.Dog является подтипом com.example.practic.interview_questions.Animal.
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
