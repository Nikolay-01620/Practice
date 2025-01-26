package com.example.practic.themes.rx_3.disposable
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

fun main() {
    val compositeDisposable = CompositeDisposable()

// Подписка 1
    val disposable1 = Observable.interval(1, TimeUnit.SECONDS)
        .subscribeOn(Schedulers.io())
        .subscribe { data ->
            println("Таймер 1: $data")
        }

// Подписка 2
    val disposable2 = Observable.interval(2, TimeUnit.SECONDS)
        .subscribeOn(Schedulers.io())
        .subscribe { data ->
            println("Таймер 2: $data")
        }

// Добавляем все подписки в CompositeDisposable
    compositeDisposable.addAll(disposable1,disposable2)

// Отписка от всех подписок сразу
    compositeDisposable.dispose()


}
