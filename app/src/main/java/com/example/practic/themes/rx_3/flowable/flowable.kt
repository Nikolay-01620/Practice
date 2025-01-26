package com.example.practic.themes.rx_3.flowable

import io.reactivex.Flowable
import io.reactivex.FlowableSubscriber
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

fun main() {
    // Создаем Flowable, который эмитирует числа от 1 до 3
    val flowable = Flowable.just(1, 2, 3)

    // Создаем Subscriber, который будет реагировать на данные
    val subscriber = object : FlowableSubscriber<Int> {

        override fun onNext(t: Int) {
            println("Получено значение: $t")
        }

        override fun onSubscribe(s: Subscription) {
            println("Подписка началась")
            s.request(Long.MAX_VALUE)
        }

        override fun onError(e: Throwable) {
            println("Произошла ошибка: ${e.message}")
        }

        override fun onComplete() {
            println("Эмиссия завершена")
        }
    }

    // Подписываем Subscriber на Flowable
    flowable.subscribe(subscriber)
}
