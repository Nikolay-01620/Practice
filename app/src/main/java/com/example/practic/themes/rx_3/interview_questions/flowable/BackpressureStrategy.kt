package com.example.practic.themes.rx_3.interview_questions.flowable

import android.annotation.SuppressLint
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers

@SuppressLint("CheckResult")
fun main() {
    // Создаем Flowable с BackpressureStrategy.BUFFER
    val flowable = Flowable.create<Int>({ emitter ->
        for (i in 1..1000) {
            println("Эмиттер отправляет: $i")
            emitter.onNext(i) // Эмитим элементы
            Thread.sleep(10)  // Эмулируем задержку отправки
        }
        emitter.onComplete() // Завершаем поток
    }, BackpressureStrategy.BUFFER) // Устанавливаем стратегию BUFFER

    // Подписываемся на Flowable
    flowable
        .observeOn(Schedulers.io()) // Обработка на другом потоке
        .subscribe(
            { item ->
                println("Потребитель получил: $item")
                Thread.sleep(50) // Эмулируем медленную обработку
            },
            { error -> println("Ошибка: ${error.message}") },
            { println("Обработка завершена!") }
        )

    // Чтобы успеть увидеть результат
    Thread.sleep(6000)
}
