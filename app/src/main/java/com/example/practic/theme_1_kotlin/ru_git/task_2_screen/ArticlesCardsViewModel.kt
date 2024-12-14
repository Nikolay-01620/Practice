package com.example.practic.theme_1_kotlin.ru_git.task_2_screen

class ArticlesCardsViewModel : BaseViewModel() {

    fun loadArticles() {
        fetchData(
            action = {  }, //вызов юскейса
            onSuccess = { articles ->
                // Обработать загруженные статьи
            },
            onError = { error ->
                // Логика обработки ошибок
            }
        )
    }
}
