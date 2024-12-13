package com.example.practic.theme_1_kotlin.practice_block

fun shakerSort(list: List<Int?>?): List<Int?> {
    // Если список равен null, возвращаем пустой список
    if (list == null) return emptyList()

    // Создаем изменяемую копию списка
    val mutableList = list.toMutableList()

    // Перемещаем null-значения в конец
    val nonNulls = mutableList.filterNotNull().toMutableList()
    val nullCount = mutableList.size - nonNulls.size

    // Шейкерная сортировка для nonNulls
    var start = 0
    var end = nonNulls.size - 1
    var swapped: Boolean

    do {
        swapped = false
        // Проход слева направо
        for (i in start until end) {
            if (nonNulls[i] > nonNulls[i + 1]) {
                nonNulls[i] = nonNulls[i + 1].also { nonNulls[i + 1] = nonNulls[i] }
                swapped = true
            }
        }
        end--

        // Проход справа налево
        for (i in end downTo start + 1) {
            if (nonNulls[i - 1] > nonNulls[i]) {
                nonNulls[i - 1] = nonNulls[i].also { nonNulls[i] = nonNulls[i - 1] }
                swapped = true
            }
        }
        start++
    } while (swapped)

    // Возвращаем отсортированный список с null-значениями в конце
    return nonNulls + List(nullCount) { null }
}

fun main() {
   println( shakerSort(listOf(null, 8, 2, 3, 5, null, 6, null)))
}
