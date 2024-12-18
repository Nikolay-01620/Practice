package com.example.practic.other.inline

/*
* Пример:
Без crossinline (разрешён "неограниченный возврат"):

inline fun test(block: () -> Unit) {
    block() // Лямбда вызывается здесь
    println("After block") // Этот код не выполнится, если в block есть return
}

fun com.example.practic.interview_questions.main() {
    test {
        println("Inside block")
        return // Завершает всю функцию com.example.practic.interview_questions.main!
    }
    println("This will not be printed")
}



*/


/** С crossinline (ограничиваем возврат):*/

inline fun test(crossinline block: () -> Unit) {
    block()
    println("After block")
}

fun main() {
    test {
        println("Inside block")
        return@test
    }
    println("This will be printed")
}
