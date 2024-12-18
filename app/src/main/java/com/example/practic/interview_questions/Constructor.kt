class PersonTwo(
    var name: String,
    val age: Int
) {

    // Вторичный конструктор с параметрами Boolean
    constructor(name1: Boolean, name2: Boolean) : this(
        name = if (name1 && name2) "Kolya" else "Unknown", // Пример логики для поля name
        age = if (name1 && name2) 5 else 0  // Пример логики для поля age
    ) {
        // Можно добавить дополнительную логику для второго конструктора, если нужно
    }
}

fun main() {
    // Создаем объект с основным конструктором
    val person1 = PersonTwo("Alex", 30)

    // Создаем объект с вторичным конструктором, который использует Boolean параметры
    val person2 = PersonTwo(true, false)

    println("Person1: ${person1.name}, ${person1.age}") // Выведет: Person1: Alex, 30
    println("Person2: ${person2.name}, ${person2.age}") // Выведет: Person2: Unknown, 0
}
