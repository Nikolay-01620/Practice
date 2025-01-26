package com.example.practic.themes.rx_3.observable

import android.annotation.SuppressLint
import io.reactivex.Observable
import io.reactivex.observables.ConnectableObservable

@SuppressLint("CheckResult")
fun main() {
    // Создаем Observable
    val observable = Observable.create<String> { emitter ->
        emitter.onNext("Hello")
        emitter.onNext("RxJava")
        emitter.onComplete()
    }

    // Преобразуем его в ConnectableObservable
    val connectableObservable: ConnectableObservable<String> = observable.publish()

    // Подписываемся до вызова connect()
    connectableObservable.subscribe { println("Получено: $it") }

    // Эмиссия не начнется, пока не вызовем connect()
    connectableObservable.connect()

}
