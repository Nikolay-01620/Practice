package com.example.practic.themes.rx_3.practice_block.tasks_2.discount_cards_5

import android.annotation.SuppressLint
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import kotlin.random.Random

// Метод для симуляции запроса к первому серверу
fun getDiscountCardsFromServer1(): Observable<List<String>> {
    return Observable.create { emitter ->
        try {
            // Генерируем случайную ошибку
            if (Random.nextBoolean()) {
                throw Exception("Server 1 Error")  // Генерация ошибки
            }

            // Возвращаем список карт, если ошибки нет
            emitter.onNext(listOf("Card 1A", "Card 1B"))
            emitter.onComplete()
        } catch (e: Exception) {
            emitter.onError(e)  // Пробрасываем ошибку
        }
    }.subscribeOn(Schedulers.io())
        .delay(1, TimeUnit.SECONDS)  // Симуляция времени ответа сервера
}


@SuppressLint("CheckResult")
fun getDiscountCardsFromServerFix(): Observable<List<String>> {
    return Observable.just(listOf("Card 1A", "Card 1B"))
        .delay(1, TimeUnit.SECONDS)  // Симуляция времени ответа сервера
}


// Метод для симуляции запроса ко второму серверу
fun getDiscountCardsFromServer2(): Observable<List<String>> {
    return if (Random.nextBoolean()) {
        Observable.error(Exception("Server 2 Error"))  // Генерация ошибки
    } else {
        Observable.just(listOf("Card 2A", "Card 2B"))
            .delay(1, TimeUnit.SECONDS)  // Симуляция времени ответа сервера
    }
}

// Функция для получения и комбинирования карт (если 1 из запросов падает, не выводить ничего)
@SuppressLint("CheckResult")
fun fetchDiscountCards() {
    Observable.zip(
        getDiscountCardsFromServer1().onErrorResumeNext(getDiscountCardsFromServerFix()),  // Если ошибка, возвращаем пустой список
        getDiscountCardsFromServer2().onErrorReturn { emptyList() }
    )  // Если ошибка, возвращаем пустой список
    { cards1, cards2 ->
        cards1 + cards2  // Объединяем два списка
    }
        .subscribeOn(Schedulers.io())  // Выполняем на фоновом потоке
        .observeOn(Schedulers.newThread())  // Выводим результат на новом потоке
        .subscribe(
            { result ->
                if (result.isNotEmpty()) {
                    println("Combined Discount Cards: $result")
                } else {
                    println("No discount cards available.")  // Если оба запроса не удались
                }
            },
            { error ->
                println("Error: ${error.message}")  // Если произошла ошибка
            }
        )
}

// Входная точка программы
fun main() {
    fetchDiscountCards()
    Thread.sleep(3000)  // Подождем 3 секунды, чтобы получить результат
}

