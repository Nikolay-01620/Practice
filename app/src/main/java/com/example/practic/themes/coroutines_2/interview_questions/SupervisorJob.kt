package com.example.practic.themes.coroutines_2.interview_questions

/*
fun com.example.practic.theme_2_coroutines.com.example.practic.themes.rx_3.Disposable.main() = runBlocking {
    // Создание родительского scope с SupervisorJob
    val scope = CoroutineScope(SupervisorJob())

    val parentJob = launch {
        // Создание дочерних корутин
        val job1 = scope.launch {
            println("job1 start")
            delay(2000) // имитируем работу
            throw IOException("Ошибка в job1") // ошибка в job1
        }

        val job2 = scope.launch {
            println("job2 start")
            delay(4000) // имитируем работу
            println("job2 end") // job2 завершится успешно
        }

        val job3 = scope.launch {
            println("job3 start")
            delay(3000) // имитируем работу
            println("job3 end") // job3 завершится успешно
        }

        // Ждем завершения всех дочерних корутин
        job1.join()
        job2.join()
        job3.join()

        println("parent job finished")
    }

    parentJob.join() // Ждем завершения родительской корутины
}
*/
