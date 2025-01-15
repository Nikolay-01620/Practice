package com.example.practic.themes.theme_2_coroutines.interview_questions


/** Пример: Создание горячего потока с StateFlow
Предположим, у нас есть Flow, который генерирует числа,
и мы хотим хранить только последнее значение, которое
будет доступно в любой момент времени. */



/*
fun main() = runBlocking {
    // Создаем Flow, который генерирует числа от 1 до 5
    val numbersFlow = flow {
        for (i in 1..5) {
            delay(500) // Имитируем асинхронные операции
            emit(i)    // Эмитируем число
        }
    }

    // Преобразуем Flow в StateFlow с дефолтным значением 0
    val stateFlow = numbersFlow.stateIn(this, SharingStarted.Eagerly, 0)

    // Подписываемся на stateFlow и выводим значения
    launch {
        stateFlow.collect { value ->
            println("Received value: $value")
        }
    }

    // Ждем завершения работы
    delay(3000)
}
*/
