package com.example.practic.themes.rx_3

import android.annotation.SuppressLint
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

@SuppressLint("CheckResult")
fun main() {
    Observable.just("Data")
        .subscribeOn(Schedulers.io())  // Подписка и начальная загрузка данных происходит в фоновом потоке
        .observeOn(Schedulers.trampoline())  // Обработка данных и вывод на UI будет на главном потоке
        .subscribe { println(it) }

}