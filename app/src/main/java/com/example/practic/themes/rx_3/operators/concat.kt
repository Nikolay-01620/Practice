package com.example.practic.themes.rx_3.operators

import android.annotation.SuppressLint
import io.reactivex.Observable

@SuppressLint("CheckResult")
fun main() {
    // Создаём три Observable с данными о ресторанах
    val restaurant1 = Observable.just("Restaurant1: Menu1", "Restaurant1: Menu2")
    val restaurant2 = Observable.just("Restaurant2: Menu1", "Restaurant2: Menu2")
    val restaurant3 = Observable.just("Restaurant3: Menu1", "Restaurant3: Menu2")

    // Объединяем их поочерёдно
    Observable.concat(restaurant1, restaurant2, restaurant3)
        .subscribe(
            { menu -> println(menu) }, // Обрабатываем каждый элемент
            { error -> println("Error: $error") }, // Обрабатываем ошибку
            { println("All menus loaded!") } // Завершаем обработку
        )
}
