package com.example.practic.themes.theme_2_coroutines.practice_block

import kotlinx.coroutines.*

fun main() = runBlocking {
    cancelSelectedChildCoroutines()
}

suspend fun cancelAllChildCoroutines() {

    val scope = CoroutineScope(Dispatchers.IO)

    val parentJob = scope.launch {

        println("Parent job started")
        delay(500)


        val job1 = launch {
            println("Job 1 started")
            delay(1000)
            println("Job 1 completed")
        }

        val job2 = launch {
            println("Job 2 started")
            delay(1000)
            println("Job 2 completed")
        }

        job1.join()
        job2.join()

        delay(500)
        println("Parent job completed")
    }


    parentJob.join()
    println("Main task completed")

    println("Cancelling all children of parent job")
    parentJob.cancelChildren()

}


suspend fun cancelSelectedChildCoroutines() {

    val scope = CoroutineScope(Dispatchers.IO)

    val parentJob = scope.launch {

        println("Parent job started")
        delay(500)

        val job1 = launch {
            println("Job 1 started")
            delay(1000)
            println("Job 1 completed")
        }

        val job2 = launch {
            println("Job 2 started")
            delay(1000)
            println("Job 2 completed")
        }

        // Выборочная отмена джоб

        println("Cancelling Job 1")
        job1.cancel()

        job2.join()

        delay(500)
        println("Parent job completed")
    }

    parentJob.join()
    println("Main task completed")
}
