open class BaseClass
class ClassA(val value: String) : BaseClass()
class ClassB(val number: Int) : BaseClass()
class ClassC(val flag: Long) : BaseClass()
class ClassD(val list: List<Int>) : BaseClass()
class ClassE(val map: Map<String, Any>) : BaseClass()

val mixedList: List<BaseClass> = listOf(
    ClassA("67"),
    ClassB(67),
    ClassC(67L),
    ClassD(listOf(1, 2, 3)),
    ClassE(mapOf("key" to "value")),
)

fun List<BaseClass>.findFirstInt(): Int? {
    return this.filterIsInstance<ClassB>().map { it.number }.firstOrNull()
}