package com.example.practic.themes.rx_3.interview_questions.observable

import android.annotation.SuppressLint
import io.reactivex.Observable

@SuppressLint("CheckResult")
fun main() {
    Observable.just("Привет", "RxJava", "Мир")
        .subscribe(
            { data -> println("Получено: $data") },   // onNext
            { error -> println("Ошибка: $error") },   // onError
            { println("Эмиссия завершена") }          // onComplete
        )

}