package com.example.practic.themes.sdk_4.practice_block.router_1

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.practic.R

class FragmentRouter(private val activity: FragmentActivity) {

    fun navigateTo(fragment: Fragment, addToBackStack: Boolean = true) {
        val transaction = activity.supportFragmentManager.beginTransaction()
            .replace(R.id.placeHolder, fragment)

        if (addToBackStack) {
            transaction.addToBackStack(null)
        }
        transaction.commit()
    }

    fun goBack() {
        activity.supportFragmentManager.popBackStack()
    }
}
