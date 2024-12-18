package com.example.practic.interview_questions

fun main() {
}

/**
data class в Kotlin автоматически является final.
Это означает, что от него нельзя наследоваться.

но сам наследовать может */
data class Data(val name: Int = 6) : Data2() {
    val name3 = name.hashCode()
}


open class Data2(val name2: Int = 6)