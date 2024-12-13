package com.example.practic.theme_1_kotlin.practice_block

data class Key(
    val field1: Int,

    // При перезаписи значения в переменную,перезапишется и индекс
    var field2: String
) {
    var field3: String? = null
}

