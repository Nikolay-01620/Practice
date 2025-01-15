package com.example.practic.themes.theme_2_coroutines.practice_block

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.delay


fun main() = runBlocking {
    flowOf(1, 2, 3, 4, 5)
        .throttleLatest(1000)
        .collect { value ->
            println(value)
        }
}

fun <T> Flow<T>.throttleLatest(timeoutMillis: Long): Flow<T> = this
    .conflate()  // Пропускает промежуточные элементы
    .transform {
        emit(it)  // Эмитит последнее значение
        delay(timeoutMillis)  // Ожидает перед тем, как позволить следующему значению поступить
    }
