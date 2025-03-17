package com.example.dagger.di

// DatabaseService: сервис для работы с базой данных
class DatabaseService {
    fun fetchData(): String {
        return "Data from Database"
    }
}

// UserService: сервис, который зависит от DatabaseService
class UserService(private val databaseService: DatabaseService) {
    fun getUserData(): String {
        return "User data: ${databaseService.fetchData()}"
    }
}

// MainActivity: главная активность, которая зависит от UserService
class MainActivity {
    private lateinit var userService: UserService

    fun onCreate() {
        // Создание зависимостей вручную
        val databaseService = DatabaseService()
        userService = UserService(databaseService)

        // Теперь можно использовать userService
        println(userService.getUserData())
    }
}
