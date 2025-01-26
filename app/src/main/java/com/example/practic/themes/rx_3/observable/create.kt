package com.example.practic.themes.rx_3.observable

import android.annotation.SuppressLint
import io.reactivex.Observable

@SuppressLint("CheckResult")
fun main() {
    val observable = Observable.create<String> { emitter ->
        emitter.onNext("Привет")  // Эмитируем данные
        emitter.onNext("RxJava")  // Еще данные
        emitter.onComplete()      // Завершаем эмиссию
    }

    observable.subscribe(
        { data -> println("Получено: $data") },   // onNext
        { error -> println("Ошибка: $error") },   // onError
        { println("Эмиссия завершена") }          // onComplete
    )
}
