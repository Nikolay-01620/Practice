/*
package com.example.practic.theme_2_coroutines.practice_block

import kotlinx.coroutines.*

fun main() = runBlocking(Dispatchers.IO) {  // Корневая корутина с диспетчером Main
    // Задачи выполняются на главном диспетчере
    val job1 = async {
        println("Task 1 started")
        delay(1000)
        println("Task 1 completed")
    }

    val job2 = async {
        println("Task 2 started")
        delay(500)
        println("Task 2 completed")
    }

    // Ждем выполнения обеих задач
    job1.await()
    job2.await()

    println("All tasks completed")
}
*/
