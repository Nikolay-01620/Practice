package com.example.practic.theme_1_kotlin.ru_git.task_2_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    private val _dataState = MutableStateFlow<DataState<Any>>(DataState.Loading)
    val dataState: StateFlow<DataState<Any>> get() = _dataState

    protected fun <T : Any> fetchData(
        action: suspend () -> T,
        onSuccess: (T) -> Unit,
        onError: (Throwable) -> Unit = {}
    ) {
        viewModelScope.launch {
            _dataState.value = DataState.Loading
            try {
                val result = action()
                _dataState.value = DataState.Success(result)
                onSuccess(result)
            } catch (e: Exception) {
                _dataState.value = DataState.Error(e)
                onError(e)
            }
        }
    }
}
