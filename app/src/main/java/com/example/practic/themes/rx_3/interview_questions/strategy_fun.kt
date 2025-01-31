package com.example.practic.themes.rx_3.interview_questions

import android.annotation.SuppressLint
import io.reactivex.BackpressureStrategy
import io.reactivex.Observable

@SuppressLint("CheckResult")
fun main() {

    Observable.create<Int> { emitter ->
        for (i in 1..100) {
            emitter.onNext(i)
        }
        emitter.onComplete()
    }
        .toFlowable(BackpressureStrategy.BUFFER) // Преобразуем Observable в Flowable с backpressure
        .onBackpressureBuffer() // Применяем onBackpressureBuffer для обработки переполнения
        .subscribe { data ->
            println(data)
        }


}