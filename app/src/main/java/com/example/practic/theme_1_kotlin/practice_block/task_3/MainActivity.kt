package com.example.practic.theme_1_kotlin.practice_block.task_3

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.practic.R
import findFirstInt
import mixedList

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val showButtonInt = findViewById<Button>(R.id.showInt)
        val firstInt = mixedList.findFirstInt()

        showButtonInt.setOnClickListener {
            Toast.makeText(this, "Найденный класс Int = $firstInt", Toast.LENGTH_LONG).show()
        }

    }
}