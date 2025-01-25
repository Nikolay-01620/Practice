package com.example.practic.themes.rx_3

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


fun main() {


// Создаем Observable, который сразу возвращает "Hello, RxJava"
    val observable = Observable.just("Hello, RxJava")

    val disposable = observable
        .subscribe { data ->
            // Обрабатываем данные
            println(data) // Выводим данные на экран или обновляем UI
        }

// Отписка, когда данные больше не нужны:
    disposable.dispose()


}



