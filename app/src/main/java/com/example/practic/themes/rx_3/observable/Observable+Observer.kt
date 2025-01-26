package com.example.practic.themes.rx_3.observable

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

fun main() {
    // Создаем Observable, который эмитирует числа от 1 до 3
    val observable = Observable.just(1, 2, 3)

    // Создаем Observer, который будет реагировать на данные
    val observer = object : Observer<Int> {
        override fun onSubscribe(d: Disposable) {
            println("Подписка началась")
        }

        override fun onNext(t: Int) {
            println("Получено значение: $t")
        }

        override fun onError(e: Throwable) {
            println("Произошла ошибка: ${e.message}")
        }

        override fun onComplete() {
            println("Эмиссия завершена")
        }
    }

    // Подписываем Observer на Observable
    observable.subscribe(observer)
}
