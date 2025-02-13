package com.example.practic.themes.sdk_4.interview_questions.interrelation_of_fragments.bridge

import androidx.appcompat.app.AppCompatActivity
import com.example.practic.R

class MainActivity : AppCompatActivity(),
    com.example.practic.themes.sdk_4.interview_questions.interrelation_of_fragments.bridge.FragmentOwner {

    override fun passDataToFragment(data: String) {
        val fragment = supportFragmentManager.findFragmentById(R.id.FirstFragment) as? FirstFragment
        fragment?.receiveData(data)
    }
}
