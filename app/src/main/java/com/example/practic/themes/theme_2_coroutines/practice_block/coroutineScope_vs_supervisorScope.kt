/*
package com.example.practic.theme_2_coroutines.practice_block

import kotlinx.coroutines.*

fun main() = runBlocking {


    println(runAsyncTasksWithSupervisor())
    //println(runAsyncTasksWithCoroutineScope())


}


suspend fun runAsyncTasksWithSupervisor(): String {
    val supervisorJob = SupervisorJob()  // Используем SupervisorJob для изоляции ошибок
    val scope = CoroutineScope(Dispatchers.Default + supervisorJob)

    return try {
        scope.launch {
            val job1 = scope.async {
                println("Task 1 started")
                delay(1000)
                println("Task 1 completed")
            }

            val job2 = scope.async {
                println("Task 2 started")
                delay(500)
                throw Exception("Error in Task 2")
            }

            job1.await() // Не отменяется, несмотря на ошибку в job2
            job2.await() // Проброс исключения, но другие задачи не будут отменены


        }.join()
        "runAsyncTasksWithSupervisor completed"

    } catch (e: Exception) {
        "Exception caught: ${e.message}"
    }

}


suspend fun runAsyncTasksWithCoroutineScope(): String {

    return try {
        coroutineScope {
            val job1 = async {
                println("Task 1 started")
                delay(1000)
                println("Task 1 completed")
            }
            val job2 = async {
                println("Task 2 started")
                delay(1000)
                throw Exception("Error in Task 2")
            }

            job1.await()
            job2.await()
        }

    } catch (e: Exception) {
        "Exception caught: ${e.message}"
    }
}
*/
