package com.example.practic.theme_1_kotlin.ru_git.task_2_screen

/**
 * Sealed класс для состояния данных: загрузка, успех или ошибка.
 */
sealed class DataState<out T> {

    /** Загрузка — данные еще не получены. */
    data object Loading : DataState<Nothing>()

    /** Успех — данные получены, содержат T */
    data class Success<out T>(val data: T) : DataState<T>()

    /** Ошибка — произошла ошибка, содержится исключение. */
    data class Error(val exception: Throwable) : DataState<Nothing>()
}
