package com.example.practic.themes.coroutines_2.practice_block

import kotlinx.coroutines.*

fun main() = runBlocking {


    // println(runAsyncTasksWithSupervisor())
    println(runAsyncTasksWithCoroutineScope())


}

suspend fun runAsyncTasksWithSupervisor(): String {
    val supervisorJob = SupervisorJob()  // Используем SupervisorJob для изоляции ошибок
    val scope = CoroutineScope(Dispatchers.Default + supervisorJob)

    scope.launch {
        val job1 = scope.async {
            println("Task 1 started")
            delay(1000)
            println("Task 1 completed")
        }

        val job2 = scope.async {
            println("Task 2 started")
            throw Exception("Error in Task 2")
        }

        job1.await()
        job2.await()
    }.join() // Если тут не вызвать ожидание, корутины не выполнятся


    return "runAsyncTasksWithSupervisor completed"
}


/** Для обработки ошибок без supervisorJob нужно обрабатывать ошибки отдельно в каждой корутине
иначе отмена родительского скоупа,в случае проброса ошибки в одной из дочерних  */
suspend fun runAsyncTasksWithCoroutineScope(): String {

    coroutineScope {
        val job1 = async {
            try {
                println("Task 1 started")
                delay(1000)
                println("Task 1 completed")
            } catch (e: Exception) {
                println("Error in Task 1: ${e.message}")
            }
        }

        val job2 = async {
            try {
                println("Task 2 started")
                delay(1000)
                throw Exception("Error in Task 2")
            } catch (e: Exception) {
                println("Error in Task 2: ${e.message}")
            }
        }

        // Ждем завершения всех задач
        job1.await()
        job2.await()
    }
    return "runAsyncTasksWithCoroutineScope completed"
}


/** После проброса ошибки возврата из род.скоупа не будет  */
suspend fun runAsyncTasksWithCoroutineScope1(): String {

    coroutineScope {

        val job1 = async {
            println("Task 1 started")
            delay(1000)
        }

        val job2 = async {
            println("Task 2 started")
            delay(1000)
            throw Exception("Error in Task 2")
        }

        // Ждем завершения всех задач
        job1.await()
        job2.await()
    }
    return "runAsyncTasksWithCoroutineScope completed"
}

