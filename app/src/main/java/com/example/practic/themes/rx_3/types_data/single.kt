package com.example.practic.themes.rx_3.types_data

import io.reactivex.Single

fun main() {
    val disposable = Single.just("Result")
        .subscribe(
            { println("Success: $it") },
            { println("Error: $it") }
        )

    disposable.dispose() // Прерывает выполнение

}