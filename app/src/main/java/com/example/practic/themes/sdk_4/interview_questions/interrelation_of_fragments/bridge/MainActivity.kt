package com.example.practic.themes.sdk_4.interview_questions.interrelation_of_fragments.bridge

import androidx.appcompat.app.AppCompatActivity
import com.example.practic.R

class MainActivity : AppCompatActivity(),
    FragmentOwner {

    override fun passDataToFragment(data: String) {
        val fragment = supportFragmentManager.findFragmentById(R.id.FirstFragment) as? com.example.practic.themes.sdk_4.interview_questions.interrelation_of_fragments.bridge.FirstFragment
        fragment?.receiveData(data)
    }
}
