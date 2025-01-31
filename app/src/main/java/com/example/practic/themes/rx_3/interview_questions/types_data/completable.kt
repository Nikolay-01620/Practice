package com.example.practic.themes.rx_3.interview_questions.types_data

import android.annotation.SuppressLint
import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers

@SuppressLint("CheckResult")
fun main() {

    val completable = Completable.create { emitter ->

        println("Task started...")
        Thread.sleep(2000)
        println("Task completed successfully.")
        emitter.onComplete() // Завершаем Completable успешно

    }

    // Подписка на Completable
    completable
        .subscribeOn(Schedulers.io()) // Выполняем на другом потоке
        .observeOn(Schedulers.single()) // Печатаем результат на главном потоке
        .subscribe(
            { println("Completed successfully!") }, // onComplete
            { throwable -> println("Error occurred: $throwable") } // onError
        )

    // Ждем, чтобы завершилась работа Completable
    Thread.sleep(3000)
}
