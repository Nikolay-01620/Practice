package com.example.practic.themes.rx_3.practice_block.task_1

import android.annotation.SuppressLint
import android.util.Log
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/** Демонстрация работы subscribeOn с observeOn */
@SuppressLint("CheckResult")
fun main() {
    Observable.timer(10, TimeUnit.MILLISECONDS, Schedulers.newThread())
        .subscribeOn(Schedulers.io())
        .map {
            Log.d("HAHAHA", "mapThread = ${Thread.currentThread().name}")
        }

        /** doOnSubscribe — позволяет выполнить действие, как только происходит подписка,
        но без изменения потока или поведения самой подписки.
        Этот оператор не влияет на Observable.*/
        .doOnSubscribe {
            Log.d("HAHAHA", "onSubscribeThread = ${Thread.currentThread().name}")
        }
        .subscribeOn(Schedulers.computation())  /** игнор*/
        .observeOn(Schedulers.single())
        .flatMap {
            Log.d("HAHAHA", "flatMapThread = ${Thread.currentThread().name}")
            Observable.just(it)
                .subscribeOn(Schedulers.io())  /** не игнор, так как создается просто вложенный observable*/
        }
        .subscribe {
            Log.d("HAHAHA", "subscribeThread = ${Thread.currentThread().name}")
        }
}



