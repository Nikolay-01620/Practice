package com.example.practic.themes.theme_2_coroutines.interview_questions

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val channel = Channel<Int>()

    // Первая корутина отправляет данные в канал
    launch {
        for (x in 1..5) {
            channel.send(x * x)  // Отправляем квадрат числа
        }
    }

    // Первая корутина получает данные из канала
    val firstReceiver = launch {
        repeat(5) {
            val value = channel.receive()  // Получаем данные из канала
            println("Received in first receiver: $value")  // Печатаем полученные данные
        }
    }

    // Вторая корутина также получает данные из канала
    val secondReceiver = launch {
        repeat(5) {
            val value = channel.receive()  // Получаем данные из канала
            println("Received in second receiver: $value")  // Печатаем полученные данные
        }
    }

    // Ожидаем, что все данные будут получены, и только потом закрываем канал
    firstReceiver.join()
    secondReceiver.join()

    channel.close()  // Теперь можно закрывать канал
}
