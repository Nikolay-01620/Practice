package com.example.practic.themes.sdk_4.practice_block.router

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.practic.R


class RouterFragment : Fragment(R.layout.sdk_fragment_one) {

    companion object {
        @JvmStatic
        fun newInstance() = RouterFragment()
    }

    fun navigateToFragment(idHolder:Int,fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(idHolder, fragment)
            .addToBackStack(null)
            .commit()
    }
}
