package com.example.practic.themes.sdk_4.interview_questions.interrelation_of_fragments.result_API

import android.app.Activity
import android.content.Intent
import androidx.fragment.app.Fragment

class FirstFragment : Fragment() {

    fun sendResultToActivity() {
        val resultIntent = Intent().apply {
            putExtra("result", "Some Data")
        }
        requireActivity().setResult(Activity.RESULT_OK, resultIntent)
        requireActivity().finish()
    }
}
