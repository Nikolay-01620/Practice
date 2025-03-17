package com.example.practic.themes.coroutines_2

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random


/** Написать функцию, которая делает несколько асинхронно запросов
и в случае ошибки пытается повторить запрос до трех раз. */

fun main() = runBlocking {
    val ids = listOf(1, 2, 3, 4, 5)

    /** Преобразование входных данных в асинхронные запросы */
    val defferedList = ids.map {
        async {
            getUserByIdWithRetry(it)
        }
    }

    defferedList.forEach {
        try {
            println(it.await())
        } catch (e: Exception) {
            e.message
        }
    }
}

suspend fun getUserByIdWithRetry(id: Int): String {

    /** На каждой из 3 итераций repeat проверяется успешность запроса */
    repeat(3) { currentIterationIndex ->

        try {
            // Возврат результата запроса
            return getUserById(id)

        } catch (e: Exception) {

            /** Если это последняя попытка ( текущий индекс = 2), то после
            возвращаем сообщение об ошибке */
            if (currentIterationIndex == 2) {
                 throw e
            }
        }
    }
    throw Exception("error getting user $id")
}



suspend fun getUserById(id: Int): String {
    delay(1000)
    return if (Random.nextBoolean()) "User $id" else throw Exception("INVALID ID")

}
