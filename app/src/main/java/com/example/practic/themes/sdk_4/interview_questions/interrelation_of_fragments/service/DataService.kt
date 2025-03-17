package com.example.practic.themes.sdk_4.interview_questions.interrelation_of_fragments.service

import android.app.IntentService
import android.content.Intent

class DataService : IntentService("DataService") {

    @Deprecated("Deprecated in Java")
    override fun onHandleIntent(intent: Intent?) {
        // Обрабатываем данные
        val data = "Processed Data"
        val broadcastIntent = Intent("com.example.broadcast.DATA_PROCESSED")
        broadcastIntent.putExtra("result", data)
        sendBroadcast(broadcastIntent)
    }
}
