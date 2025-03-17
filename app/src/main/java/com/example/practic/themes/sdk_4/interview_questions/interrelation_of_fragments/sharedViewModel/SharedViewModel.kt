package com.example.practic.themes.sdk_4.interview_questions.interrelation_of_fragments.sharedViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    val data = MutableLiveData<String>()
}
