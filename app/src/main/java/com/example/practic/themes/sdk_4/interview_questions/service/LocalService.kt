package com.example.practic.themes.sdk_4.interview_questions.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import java.util.Random

class LocalService : Service() {
    private val binder = LocalBinder()

    val randomNumber: Int
        get() = Random().nextInt(100)

    inner class LocalBinder : Binder() {
        fun getService(): LocalService = this@LocalService
    }

    override fun onBind(intent: Intent): IBinder {
        return binder
    }
}
