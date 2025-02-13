package com.example.practic.themes.sdk_4.interview_questions.interrelation_of_fragments.service

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.practic.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_activity_main)

        val intent = Intent(this, DataService::class.java)
        startService(intent)
    }
}
