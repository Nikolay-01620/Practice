package com.example.practic.themes.theme_2_coroutines.practice_block

import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flowOf

@OptIn(FlowPreview::class)
suspend fun main() {


    flowOf(1, 2, 3, 4, 5)
        .debounce(1) // Пропустит все события, происходящие быстрее, чем за 1 миллисекунду
        .collect { value -> println(value) }

}