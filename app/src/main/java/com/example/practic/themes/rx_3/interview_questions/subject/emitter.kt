package com.example.practic.themes.rx_3.interview_questions.subject

import android.annotation.SuppressLint
import io.reactivex.subjects.AsyncSubject

@SuppressLint("CheckResult")
fun main() {
    // Создаем PublishSubject, который будет эмитировать данные
    val subject = AsyncSubject.create<String>()

    // Эмитим данные ДО подписки
    subject.onNext("Item 1")
    subject.onNext("Item 2")

    // Подписка 1
    subject.subscribe { value ->
        println("Subscriber 1 received: $value")
    }

    // Эмитим еще данные
    subject.onNext("Item 3")
    subject.onNext("Item 4")
    subject.onNext("Item 5")
    subject.onComplete()

    // Ждем завершения, чтобы увидеть все данные
    Thread.sleep(1000)
}
