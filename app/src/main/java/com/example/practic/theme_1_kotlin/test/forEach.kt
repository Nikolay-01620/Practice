package com.example.practic.theme_1_kotlin.test

/**
Описание кода:
У нас есть список: listOf(1, 2, 3).
Мы используем функцию forEach, которая перебирает каждый элемент списка.
Внутри forEach есть анонимная функция (лямбда), помеченная меткой test@.
Это метка используется для управления потоком выполнения внутри лямбды.
Внутри лямбды есть условие:
kotlin
Копировать код
if (it == 2) return@test
Это условие проверяет, если текущий элемент равен 2,
то выполнение лямбды будет немедленно завершено с помощью return@test. */


fun main() {
    listOf(1, 2, 3).forEach test@{
        if (it == 2) return@test

        print("$it, ")
    }
}
