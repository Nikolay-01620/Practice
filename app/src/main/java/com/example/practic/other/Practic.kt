fun List<Any>.findFirstInt(): Int? {
    return this.firstOrNull { it is Int } as? Int
}

fun main() {
    // Указываем тип списка
    val mixedList: List<Any> = listOf("Hello", 42, 3.14, true)

    // Ищем первое Int
    val foundInt = mixedList.findFirstInt()
    println("First Int in the list: $foundInt")
}
