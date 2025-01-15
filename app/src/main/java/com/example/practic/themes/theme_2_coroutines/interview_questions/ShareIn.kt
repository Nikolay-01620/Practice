package com.example.practic.themes.theme_2_coroutines.interview_questions


/** Пример: Использование shareIn для мультиподписки
Предположим, у нас есть Flow, который генерирует события, и мы хотим,
чтобы несколько корутин могли одновременно слушать эти события.*/


/*
fun main() = runBlocking {


    // Создаем Flow, который генерирует числа от 1 до 5
    val numbersFlow = flow {
        for (i in 1..5) {
            delay(500) // Имитируем асинхронные операции
            emit(i)    // Эмитируем число
        }
    }

    // Преобразуем Flow в SharedFlow, используя shareIn
    val sharedFlow = numbersFlow.shareIn(this, SharingStarted.Eagerly)

    // Подписываемся на sharedFlow в двух разных корутинах
    launch {
        sharedFlow.collect { value ->
            println("Subscriber 1 received: $value")
        }
    }
    launch {
        sharedFlow.collect { value ->
            println("Subscriber 2 received: $value")
        }
    }

    // Ждем завершения работы
    delay(3000)
}
*/
