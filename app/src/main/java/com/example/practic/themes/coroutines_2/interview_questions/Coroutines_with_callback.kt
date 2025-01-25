package com.example.practic.themes.coroutines_2.interview_questions

/*
fun com.example.practic.theme_2_coroutines.main() = runBlocking {
    val scope = CoroutineScope(SupervisorJob()) // создаем скоуп с SupervisorJob

    // Запускаем корутину
    val job = scope.launch {
        // Запускаем асинхронную задачу с коллбэком
        performTaskWithCallback {
            if (isActive) { // Проверяем, активна ли корутина
                println("Корутину не отменили, продолжаем выполнять задачу.")
            } else {
                println("Корутину отменили, не продолжаем.")
            }
        }
    }

    delay(1000) // Имитация времени работы
    job.cancel() // Отменяем корутину
    job.join() // Ждем завершения
}

// Эта функция имитирует асинхронную задачу с коллбэком
suspend fun performTaskWithCallback(callback: () -> Unit) {
    delay(2000) // Симуляция долгой работы
    callback() // Вызов коллбэка
}
*/
