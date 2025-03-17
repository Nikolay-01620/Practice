package com.example.practic.themes.kotlin_1.ru_git.task_2_screen

class ArticlesCardsViewModel : BaseViewModel() {

    fun loadArticles() {
        fetchData(
            action = {  }, //вызов юскейса
            onSuccess = { articles ->
                // обработка загруженных статей
            },
            onError = { error ->
                // Логика обработки ошибок
            }
        )
    }
}
