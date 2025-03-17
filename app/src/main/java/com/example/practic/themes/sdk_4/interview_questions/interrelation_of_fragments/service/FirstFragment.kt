package com.example.practic.themes.sdk_4.interview_questions.interrelation_of_fragments.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment

class FirstFragment : Fragment() {

    private lateinit var receiver: BroadcastReceiver

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStart() {
        super.onStart()

        receiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                val data = intent?.getStringExtra("result")
                // Обрабатываем данные
            }
        }

        val filter = IntentFilter("com.example.broadcast.DATA_PROCESSED")
        requireActivity().registerReceiver(receiver, filter, Context.RECEIVER_NOT_EXPORTED)
    }

    override fun onStop() {
        super.onStop()
        requireActivity().unregisterReceiver(receiver)
    }
}
