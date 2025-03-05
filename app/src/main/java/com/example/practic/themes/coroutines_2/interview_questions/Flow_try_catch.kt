package com.example.practic.themes.coroutines_2.interview_questions

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    flow {
        emit(1)
        emit(2)
        emit(3)
        throw Exception("An error occurred!")
        emit(4)
    }.collect { value ->
        try {
            if (value == 3) throw Exception("Error at value 3")
            println("Received: $value")
        } catch (e: Exception) {
            println("Caught error: ${e.message}")
        }
    }
}
