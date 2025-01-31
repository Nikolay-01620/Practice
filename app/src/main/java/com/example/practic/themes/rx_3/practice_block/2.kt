package com.example.practic.themes.rx_3.practice_block

import android.annotation.SuppressLint
import android.util.Log
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.ReplaySubject

@SuppressLint("CheckResult")
fun main() {
    val subject = ReplaySubject.create<String>()
    subject.onNext("1")
    subject.onNext("2")
    subject.onNext("3")
    subject.subscribe { Log.d("TAG", it) }

    val subject2 = PublishSubject.create<String>()
    subject2.subscribe { Log.d("TAG", it) }
    subject2.onNext("1")
    subject2.onNext("2")
    subject2.onNext("3")

}