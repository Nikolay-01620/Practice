import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty
import kotlinx.coroutines.*

class CachedLaunchTime : ReadWriteProperty<Any?, Long> {


    private var cachedTime: Long = System.currentTimeMillis()


    /** Этот метод возвращает текущее значение cachedTime,
    которое инициализируется текущим временем в миллисекундах.*/
    override fun getValue(thisRef: Any?, property: KProperty<*>): Long {
        println("Get value сработал")
        return cachedTime
    }

    /** setValue: Этот метод устанавливает новое значение для cachedTime.*/
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Long) {
        println("Set value сработал")
        cachedTime = value
    }
}

class App(private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO)) {

    /** Ключевое слово by указывает на то,
    что это свойство делегируется классу CachedLaunchTime.
    Это означает, что все операции получения и установки значения
    этого свойства будут обрабатываться через CachedLaunchTime.*/
    var launchTime: Long by CachedLaunchTime()

    init {
        launchTime = System.currentTimeMillis()
        println("Значение установлено")

        startLogging() // Запуск логирования
    }

    private fun startLogging() {
        coroutineScope.launch {
            while (true) {
                delay(3000) // Задержка на 3 секунды
                println("Cached Launch Time: $launchTime") // Логирование
            }
        }
    }

    // Метод для завершения корутин, если это потребуется
    fun stopLogging() {
        coroutineScope.cancel() // Отмена всех корутин в этом скоупе
    }
}

fun main() {
    val app = App() // Создаем экземпляр приложения
    Thread.sleep(15000) // Даем время на вывод логов (15 секунд)
    app.stopLogging() // Остановка логирования (опционально)
}
