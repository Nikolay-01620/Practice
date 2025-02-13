package com.example.practic.themes.sdk_4.interview_questions.interrelation_of_fragments.sharedViewModel

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

class FirstFragment : Fragment() {
    private val sharedViewModel: com.example.practic.themes.sdk_4.interview_questions.interrelation_of_fragments.sharedViewModel.SharedViewModel by activityViewModels()

    fun sendData() {
        sharedViewModel.data.value = "Hello from FirstFragment"
    }
}
