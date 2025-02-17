package com.example.practic.themes.sdk_4.interview_questions.pagging

import android.view.View
import androidx.recyclerview.widget.RecyclerView

// Ваш ViewHolder для пагинации
class MyViewHolder() : RecyclerView.ViewHolder(binding.root) {

    private val binding:

    // Метод для привязки данных к элементу
    fun bind(data: MyData) {
        // Привязываем данные из объекта MyData к нужным видам
        binding.textView.text = data.name // Пример для текстового поля
        binding.imageView.setImageResource(data.imageRes) // Пример для изображения
    }
}


