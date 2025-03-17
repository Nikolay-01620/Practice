package com.example.practic.themes.rx_3.interview_questions.operators

import android.annotation.SuppressLint
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

@SuppressLint("CheckResult")
fun main() {
    // Поток 1: Погода
    val weatherObservable = Observable.just("Sunny").delay(1, TimeUnit.SECONDS)

    // Поток 2: Новости
    val newsObservable = Observable.just("Breaking news!").delay(2, TimeUnit.SECONDS)

    // Поток 3: Средняя температура
    val temperatureObservable = Observable.just("22°C").delay(3, TimeUnit.SECONDS)

    // Используем combineLatest для комбинирования данных
    Observable.combineLatest(
        weatherObservable,
        newsObservable,
        temperatureObservable,
        { weather: String, news: String, temperature: String ->
            "Weather: $weather, News: $news, Temperature: $temperature"
        }
    )
        .subscribe(
            { result -> println(result) },  // Печатаем результат
            { error -> println("Error: $error") }  // Обработка ошибок
        )

    // Задержка, чтобы программа не завершалась сразу
    Thread.sleep(5000)
}
