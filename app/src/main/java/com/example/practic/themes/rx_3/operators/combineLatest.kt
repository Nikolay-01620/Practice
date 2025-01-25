package com.example.practic.themes.rx_3.operators

import android.annotation.SuppressLint
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

@SuppressLint("CheckResult")
fun main() {
    // Создаем Observable, который получает данные о погоде
    val weatherObservable = Observable.just("Sunny").delay(2, TimeUnit.SECONDS)

    // Создаем Observable, который получает новости
    val newsObservable = Observable.just("Breaking news!").delay(1, TimeUnit.SECONDS)

    // Используем combineLatest для комбинирования данных
    Observable.combineLatest(
        weatherObservable,
        newsObservable,
        { weather: String, news: String ->
            "Weather: $weather, News: $news"
        }
    )
        .subscribe(
            { result -> println(result) },  // Печатаем результат
            { error -> println("Error: $error") }  // Обработка ошибок
        )

    // Для того чтобы программа не завершалась сразу, нужно немного подождать
    Thread.sleep(5000)
}
