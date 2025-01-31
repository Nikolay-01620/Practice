package com.example.practic.themes.rx_3.interview_questions.subject

import android.annotation.SuppressLint
import io.reactivex.Observable
import io.reactivex.subjects.ReplaySubject

@SuppressLint("CheckResult")
fun main() {
    // Создаем обычный Observable
    val observable = Observable.just("Item 1", "Item 2", "Item 3")

    // Создаем PublishSubject, который будет подписчиком
    val subject = ReplaySubject.create<String>()

    subject.onNext("Item 4")
    subject.onNext("Item 5")

    subject.subscribe { value ->
        println("Subscriber received: $value")
    }

    // Эмитим еще данные
    subject.onNext("Item 6")
    subject.onNext("Item 7")
    subject.onNext("Item 8")

    // Subject подписывается на Observable
    observable.subscribe(subject)
}
