package com.example.practic.theme_1_kotlin.ru_git.task_1_shared

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
                binding.getValue.text = TODO()
            },

            onError = { e ->
                binding.getValue.text = TODO()
            }
        )
    }

    private fun getValue() {
        prefs.loadAsync(
            key = "kolya",
            defaultValue = "DefaultUser ",

            onResult = { result ->
                binding.getValue.text = TODO()
            },

            onError = { e ->
                binding.getValue.text = TODO()
            }
        )
    }
}
