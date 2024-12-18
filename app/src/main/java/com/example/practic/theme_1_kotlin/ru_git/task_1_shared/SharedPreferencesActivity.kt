package com.example.practic.theme_1_kotlin.ru_git.task_1_shared

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.practic.databinding.SharedActivityBinding

class SharedPreferencesActivity : AppCompatActivity() {

    private lateinit var binding: SharedActivityBinding
    /* var pref: SharedPreferences

    init {
        pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
    }*/


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
        val pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        val valueToSave = binding.saveValue.text.toString()
        pref.saveAsync(
            key = "kolya",
            value = valueToSave,
            useCommit = false,

            onSuccess = { binding.saveValue.setText("") },
            onError = { e, s -> binding.saveValue.setText("") }
        )
    }

    private fun getValue() {
        val pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        pref.loadAsync(
            key = "kolya",
            defaultValue = "DefaultUser ",
            onResult = { binding.getValue.setText(it.toString()) },
            onError = { e -> binding.getValue.setText(e.toString()) }
        )
    }
}
