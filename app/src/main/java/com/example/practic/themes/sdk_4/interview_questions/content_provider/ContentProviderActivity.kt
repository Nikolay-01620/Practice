package com.example.practic.themes.sdk_4.interview_questions.content_provider

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.practic.databinding.ContentProviderActivityMainBinding

class ContentProviderActivity : AppCompatActivity() {

    // Создаём переменную для View Binding
    private lateinit var binding: ContentProviderActivityMainBinding

    @SuppressLint("Range", "Recycle", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Инициализация ViewBinding
        binding = ContentProviderActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Пример запроса к ContentProvider
        val uri = Uri.parse("content://com.example.practic.themes.sdk_4.interview_questions.content_provider.notesprovider/notes")
        val cursor = contentResolver.query(uri, null, null, null, null)

        cursor?.let {
            if (it.count > 0) {
                // Собираем все заметки в строку
                val notesList = StringBuilder()
                while (it.moveToNext()) {
                    val note = it.getString(it.getColumnIndex("note"))
                    notesList.append("Note: $note\n")
                }
                // Устанавливаем собранные заметки в TextView
                binding.notesTextView.text = notesList.toString()
            } else {
                // Если заметок нет, показываем текст "No notes available"
                binding.notesTextView.text = "No notes available"
            }
        } ?: run {
            // Обработка случая, если cursor == null (например, ошибка при запросе)
            binding.notesTextView.text = "Error retrieving notes"
        }
    }
}
