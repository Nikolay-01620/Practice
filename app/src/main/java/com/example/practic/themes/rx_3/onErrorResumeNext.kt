package com.example.practic.themes.rx_3

import android.annotation.SuppressLint
import io.reactivex.Observable

@SuppressLint("CheckResult")
fun main() {
    // Это Observable, который выбрасывает ошибку через 2 секунды
    val observableWithError = Observable.create<String> { emitter ->
        emitter.onNext("Hello")
        Thread.sleep(2000)
        emitter.onError(Throwable("Something went wrong!"))
    }

    // Мы применяем onErrorResumeNext для того, чтобы вместо ошибки вернуть новый Observable
    observableWithError
        .onErrorResumeNext { error: Throwable ->
            // Возвращаем новый Observable, который продолжит эмитить данные
            Observable.just("Fallback value")
        }
        .subscribe(
            { value -> println("Received: $value") },
            { error -> println("Error occurred: $error") }
        )
}
