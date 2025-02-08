package com.example.practic.themes.sdk_4.practice_block.router

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.practic.R
import com.example.practic.themes.sdk_4.practice_block.router.RouterFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sdk_activity_main)
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.placeHolder, OneFragment())
                .commit()
    }
}
