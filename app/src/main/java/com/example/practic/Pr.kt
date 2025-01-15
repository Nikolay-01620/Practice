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


//Написать функцию, которая делает несколько асинхронно запросов
//и в случае ошибки пытается повторить запрос до трех раз.

/*
fun main() = runBlocking {
    val ids = listOf(1, 2, 3, 4, 5)

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
  return  retry(3) { getUserById(id) }

}


suspend fun getUserById(id: Int): String {
    delay(3000)
    return if (Random.nextBoolean()) "User $id" else throw Exception("INVALID ID")

}
*/
