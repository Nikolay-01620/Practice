package com.example.practic.themes.rx_3.interview_questions.operators

import android.annotation.SuppressLint
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

@SuppressLint("CheckResult")
fun main() {
    val orders = listOf("Order1", "Order2", "Order3")

    Observable.fromIterable(orders) // Создаём поток заказов
        .concatMap { order ->
            // Для каждого заказа эмулируем асинхронный запрос с разным временем ответа
            Observable.just("Processed $order")
                .delay((500..1000).random().toLong(), TimeUnit.MILLISECONDS) // Эмуляция задержки
        }
        .subscribe(
            { result -> println(result) }, // Обрабатываем результат
            { error -> println("Error: $error") }, // Обрабатываем ошибку
            { println("All orders processed!") } // Завершаем обработку
        )
    Thread.sleep(3000) // Даём потоку завершить выполнение
}
