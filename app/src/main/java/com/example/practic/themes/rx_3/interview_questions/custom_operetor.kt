package com.example.practic.themes.rx_3.interview_questions

import android.annotation.SuppressLint
import io.reactivex.Flowable
import io.reactivex.FlowableTransformer

fun filterEvenNumbers(): FlowableTransformer<Int, Int> {
    return FlowableTransformer { upstream ->
        upstream.filter { it % 2 == 0 }  // Пропускаем только четные числа
    }
}

@SuppressLint("CheckResult")
fun main() {
    Flowable.just(1, 2, 3, 4, 5, 6)
        .compose(filterEvenNumbers())  // Применяем кастомный оператор через compose
        .subscribe { println(it) }  // Вывод: 2, 4, 6
}
