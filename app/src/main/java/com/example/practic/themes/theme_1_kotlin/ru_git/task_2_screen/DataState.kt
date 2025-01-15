package com.example.practic.themes.theme_1_kotlin.ru_git.task_2_screen

/**
 * Sealed класс для состояния данных: загрузка, успех или ошибка.
 */
sealed class DataState<out T> {

    /** Загрузка — данные еще не получены. */
    data object Loading : com.example.practic.themes.theme_1_kotlin.ru_git.task_2_screen.DataState<Nothing>()

    /** Успех — данные получены, содержат T */
    data class Success<out T>(val data: T) : com.example.practic.themes.theme_1_kotlin.ru_git.task_2_screen.DataState<T>()

    /** Ошибка — произошла ошибка, содержится исключение. */
    data class Error(val exception: Throwable) : com.example.practic.themes.theme_1_kotlin.ru_git.task_2_screen.DataState<Nothing>()
}
