package com.example.practic.themes.sdk_4.interview_questions.interrelation_of_fragments.sharedViewModel

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

class SecondFragment : Fragment() {
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        sharedViewModel.data.observe(viewLifecycleOwner) {
            // Получаем данные
        }
    }
}
