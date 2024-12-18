package com.example.practic.interview_questions

/**
 * Enum class с дополнительными свойствами и методами.
 * Это перечисление описывает три состояния:
 * SUCCESS (Успех), ERROR (Ошибка), LOADING (Загрузка).
 * Каждому состоянию присваивается строковое сообщение.
 */
enum class Status(val message: String) {
    SUCCESS("Operation was successful"),
    ERROR("An error occurred"),
    LOADING("Data is loading");

    /**
     * Метод, который возвращает сообщение, связанное с данным статусом.
     * @return сообщение для соответствующего статуса.
     */
    fun getStatusMessage(): String {
        return message
        /** Возвращает строку, которая была передана при создании элемента перечисления */
    }
}

fun main() {
    /** Присваиваем переменной 'status' значение 'ERROR' из перечисления Status. */
    val status = Status.ERROR

    /**
    Выводим сообщение, связанное с текущим статусом.
    В данном случае будет выведено сообщение для статуса ERROR.
     */
    println(status.getStatusMessage())  // Выведет: An error occurred
}
