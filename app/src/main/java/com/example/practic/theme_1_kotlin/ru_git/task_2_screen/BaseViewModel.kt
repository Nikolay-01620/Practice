package com.example.practic.theme_1_kotlin.ru_git.task_2_screen

/*
abstract class BaseViewModel : ViewModel() {

    protected val _dataState = MutableStateFlow<DataState<Any>>(DataState.Loading)
    val dataState: StateFlow<DataState<Any>> get() = _dataState

    protected fun <T> fetchData(
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
*/
