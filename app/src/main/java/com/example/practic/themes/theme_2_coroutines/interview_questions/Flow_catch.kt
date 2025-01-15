package com.example.practic.themes.theme_2_coroutines.interview_questions

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val flow = flow {
        emit(1)
        throw RuntimeException("Error in Flow!")  // Исключение
        emit(2)  // Это не будет эмитировано
    }.catch { e ->
        println("Caught error in flow: ${e.message}")
    }

    flow.collect { value ->
        println("Received: $value")
    }
}
