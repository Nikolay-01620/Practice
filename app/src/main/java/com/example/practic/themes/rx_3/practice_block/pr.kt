package com.example.practic.themes.rx_3.practice_block

import android.annotation.SuppressLint
import android.util.Log
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

@SuppressLint("CheckResult")
fun main() {
    Observable.timer(10, TimeUnit.MILLISECONDS, Schedulers.newThread())
        .subscribeOn(Schedulers.io())
        .map {
            Log.d("HAHAHA", "mapThread = ${Thread.currentThread().name}")
        }
        .doOnSubscribe {
            Log.d("HAHAHA", "onSubscribeThread = ${Thread.currentThread().name}")
        }
        .subscribeOn(Schedulers.computation()) // игнор
        .observeOn(Schedulers.single())
        .flatMap {
            Log.d("HAHAHA", "flatMapThread = ${Thread.currentThread().name}")
            Observable.just(it)
                .subscribeOn(Schedulers.io()) // не игнор, так как создается просто вложенный observable
        }
        .subscribe {
            Log.d("HAHAHA", "subscribeThread = ${Thread.currentThread().name}")
        }
}