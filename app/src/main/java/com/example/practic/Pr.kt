package com.example.practic

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import kotlinx.coroutines.async
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.resume
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
        println(it.await())
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
                return "Failed to fetch user $id after 3 attempts"
            }
        }
    }
    return "getUserByIdWithRetry completed"
}

suspend fun getUserById(id: Int): String {
    delay(1000)
    return if (Random.nextBoolean()) "User $id" else throw Exception("INVALID ID")

}
