package com.example.practic.themes.sdk_4.interview_questions.interrelation_of_fragments.bridge

import androidx.fragment.app.Fragment

class FirstFragment : Fragment() {
    
    fun receiveData(data: String) {
        // Обрабатываем переданные данные
    }

    fun sendData() {
        (activity as? FragmentOwner)?.passDataToFragment("Hello, World!")
    }
}
