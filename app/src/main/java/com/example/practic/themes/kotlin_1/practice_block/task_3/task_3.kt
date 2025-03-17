// Базовый класс, от которого наследуются другие классы
open class BaseClass

class ClassA(val value: String) : BaseClass()
class ClassB(val number: Int) : BaseClass()
class ClassC(val flag: Long) : BaseClass()
class ClassD(val list: List<Int>) : BaseClass()
class ClassE(val map: Map<String, Any>) : BaseClass()

// Список mixedList, содержащий объекты разных типов, наследующих BaseClass
val mixedList: List<BaseClass> = listOf(
    ClassA("67"),
    ClassB(67),
    ClassC(67L),
    ClassD(listOf(1, 2, 3)),
    ClassE(mapOf("key" to "value"))
)

/**
 * Расширение для класса List<BaseClass>, которое ищет первый объект типа ClassB.
 * Мы используем filterIsInstance для фильтрации объектов типа ClassB,
 * затем с помощью map получаем список их значений типа Int и возвращаем первое из них.
 */
fun List<BaseClass>.findFirstInt(): Int? {
    return this
        .filterIsInstance<ClassB>()  // Фильтруем только объекты типа ClassB
        .map { it.number }            // Извлекаем поле number (тип Int) из объектов ClassB
        .firstOrNull()               // Возвращаем первый найденный элемент или null, если их нет
}
