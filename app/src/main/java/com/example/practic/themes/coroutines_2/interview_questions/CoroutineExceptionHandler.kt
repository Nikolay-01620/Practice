package com.example.practic.themes.coroutines_2.interview_questions

/*
fun com.example.practic.theme_2_coroutines.com.example.practic.themes.rx_3.Disposable.com.example.practic.themes.rx_3.practice_block.task_2.discountcards_5.com.example.practic.themes.rx_3.practice_block.task_2.discountcards_5.main() = runBlocking {
    // Создание CoroutineExceptionHandler
    val coroutineExceptionHandler = CoroutineExceptionHandler { context, throwable ->
        println("Ошибка: ${throwable.message} в контексте $context")
    }

    // Создание родительского scope с CoroutineExceptionHandler
    val scope = CoroutineScope(Dispatchers.Default + coroutineExceptionHandler)

    val parentJob = scope.launch {
        // Дочерние корутины
        val job1 = launch {
            println("job1 стартует")
            delay(1000)
            throw IOException("Ошибка в job1")
        }

        val job2 = launch {
            println("job2 стартует")
            delay(2000)
            println("job2 завершена")
        }

        val job3 = launch {
            println("job3 стартует")
            delay(1500)
            throw IOException("Ошибка в job3")
        }

        // Ожидаем завершения всех дочерних корутин
        job1.join()
        job2.join()
        job3.join()
    }

    // Дожидаемся завершения родительской корутины
    parentJob.join()
}

*/
