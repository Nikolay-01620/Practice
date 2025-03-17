package com.example.dagger.service_locator

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

class UserService2(private val databaseService: DatabaseService) {
    fun getUserData(): String {
        return "User data: ${databaseService.fetchData()}"
    }
}

// Service Locator: центральное место для управления зависимостями
object ServiceLocator {
    private val databaseService = DatabaseService()

    // Возвращаем UserService, и передаем ему зависимости
    fun getUserService(): UserService {
        return UserService(databaseService)
    }

    fun getUserService2(): UserService2 {
        return UserService2(databaseService)
    }

}

// MainActivity: главная активность, которая зависит от UserService
class MainActivity {
    private lateinit var userService: UserService
    private lateinit var userService2: UserService2

    fun onCreate() {
        // Получаем зависимость через Service Locator
        userService = ServiceLocator.getUserService()
        userService2 = ServiceLocator.getUserService2()

        // Теперь можно использовать userService
        println(
            userService.getUserData() +
                    userService2.getUserData()
        )
    }
}
