package com.example.practic.other.inline

inline fun example( block: () -> Unit) {
    //someOtherFunction(block) // Ошибка: лямбда не может быть передана дальше
}

fun someOtherFunction(block: () -> Unit) {
    block()
}
