package com.example.practic.theme_1_kotlin.ru_git.task_2_screen
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
/**
 * Абстрактный BaseViewModel, управляющий состоянием данных и выполняет асинхронные запросы.
 */
abstract class BaseViewModel : ViewModel() {

    /** Состояние данных: Loading, Success или Error. */
    private val _dataState = MutableStateFlow<DataState<Any>>(DataState.Loading)
    val dataState: StateFlow<DataState<Any>> get() = _dataState

    /**
     * Функция для выполнения асинхронной операции с обработкой состояния.
     * При успешной загрузке вызывает onSuccess, при ошибке — onError.
     */
    protected fun <T : Any> fetchData(
        action: suspend () -> T, // Асинхронная операция
        onSuccess: (T) -> Unit,   // Обработчик успешного результата
        onError: (Throwable) -> Unit = {} // Обработчик ошибки
    ) {
        viewModelScope.launch {
            _dataState.value = DataState.Loading // Состояние "Загрузка"
            try {
                val result = action() // Выполнение операции
                _dataState.value = DataState.Success(result) // Успех
                onSuccess(result) // Обработка успеха
            } catch (e: Exception) {
                _dataState.value = DataState.Error(e) // Ошибка
                onError(e) // Обработка ошибки
            }
        }
    }
}
