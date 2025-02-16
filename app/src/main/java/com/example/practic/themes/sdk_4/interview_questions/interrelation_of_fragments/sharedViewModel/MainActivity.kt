package com.example.practic.themes.sdk_4.interview_questions.interrelation_of_fragments.sharedViewModel

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    val sharedViewModel: SharedViewModel by viewModels()
}
