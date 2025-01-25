package com.example.practic.themes.rx_3.operators

import android.annotation.SuppressLint
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

@SuppressLint("CheckResult")
fun main() {
    // Создаем три потока, которые эмиттят по одному элементу через 5 секунд
    val flow1 = Observable.just(1).delay(2, TimeUnit.SECONDS)
    val flow2 = Observable.just(2).delay(2, TimeUnit.SECONDS)  // Этот поток быстрее
    val flow3 = Observable.just(3).delay(2, TimeUnit.SECONDS)

    // Используем merge для комбинирования элементов потока по мере их поступления
    Observable.merge(flow1, flow2, flow3)
        .subscribe { result ->
            println("Received: $result")
        }

    // Чтобы программа не завершалась сразу, добавим задержку в конце
    Thread.sleep(3000)
}
