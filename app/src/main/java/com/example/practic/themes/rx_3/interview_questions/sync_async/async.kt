import android.annotation.SuppressLint
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

@SuppressLint("CheckResult")
fun main() {
    // Витя начинает упаковывать товар
    Observable.create<String> { emitter ->
        println("Витя начал упаковывать товар.")
        Thread.sleep(1000)  // Эмулируем, что Витя работает
        emitter.onNext("Витя ждет ножницы от Коли...")
        emitter.onComplete()
    }
        .subscribeOn(Schedulers.single()) // Все в одном потоке
        .observeOn(Schedulers.single())  // Результат в том же потоке
        .subscribe { println(it) }

    // Коля приносит ножницы через 2 секунды
    Observable.just("Коля принес ножницы!")
        .delay(2, TimeUnit.SECONDS) // Задержка перед тем, как Коля принесет ножницы
        .subscribeOn(Schedulers.single()) // Работает в том же потоке
        .observeOn(Schedulers.single())
        .subscribe { println(it) }

    // Женя упаковывает другой товар через 500мс
    Observable.just("Женя упаковывает товар!")
        .delay(500, TimeUnit.MILLISECONDS)
        .subscribeOn(Schedulers.single())
        .observeOn(Schedulers.single())
        .subscribe { println(it) }

    // Задержка для завершения работы всех асинхронных операций
    Thread.sleep(3000)
}
