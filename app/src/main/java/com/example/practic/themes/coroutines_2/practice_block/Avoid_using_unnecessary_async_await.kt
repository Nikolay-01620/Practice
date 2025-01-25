package com.example.practic.themes.coroutines_2.practice_block

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() = runBlocking {

    async {
        println("job started in default context")
        delay(1000)
        println("job in progress")

        withContext(Dispatchers.IO) {
            println("job in progress in IO context")
            delay(1000)
        }
        println("job completed in default context")

    }.await() // без возврата результата код ниже не будет выполнен

    println("Main task completed")

}