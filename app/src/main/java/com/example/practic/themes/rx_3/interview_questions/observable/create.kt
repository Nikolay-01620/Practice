package com.example.practic.themes.rx_3.interview_questions.observable

import android.annotation.SuppressLint
import io.reactivex.Observable
import io.reactivex.observables.ConnectableObservable

@SuppressLint("CheckResult")
fun main() {
    val observable = ConnectableObservable.create<String> { emitter ->
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
