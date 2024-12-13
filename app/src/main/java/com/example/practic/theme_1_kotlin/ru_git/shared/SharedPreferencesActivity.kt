package com.example.practic.theme_1_kotlin.ru_git.shared

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.practic.databinding.SharedActivityBinding

class SharedPreferencesActivity : AppCompatActivity() {

    private lateinit var binding: SharedActivityBinding
    val prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SharedActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSave.setOnClickListener {
            saveValue()
        }

        binding.buttonGet.setOnClickListener {
            getValue()
        }
    }

    private fun saveValue() {
        val valueToSave = binding.saveValue.text.toString()

        prefs.saveAsync(
            key = "kolya",
            value = valueToSave,
            useCommit = false,
            onSuccess = {
                // Успешно сохранено
                binding.getValue.text = "Value saved successfully!"
            },
            onError = { e ->
                // Ошибка при сохранении
                binding.getValue.text = "Error saving value: ${e.message}"
            }
        )
    }

    private fun getValue() {
        prefs.loadAsync(
            key = "kolya",
            defaultValue = "DefaultUser ",
            onResult = { result ->
                // Загружено значение
                binding.getValue.text = "Loaded value: $result"
            },
            onError = { e ->
                // Ошибка при загрузке
                binding.getValue.text = "Error loading value: ${e.message}"
            }
        )
    }
}
