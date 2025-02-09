package com.example.practic.themes.sdk_4.practice_block.router_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.practic.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sdk_activity_router)
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.placeHolder, OneFragment())
                .commit()
    }
}
