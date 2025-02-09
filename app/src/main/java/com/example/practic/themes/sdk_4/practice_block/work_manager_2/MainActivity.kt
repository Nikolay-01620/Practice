package com.example.practic.themes.sdk_4.practice_block.work_manager_2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.work.Constraints
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.practic.databinding.SdkActivityWorkManagerBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: SdkActivityWorkManagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SdkActivityWorkManagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val constraints = Constraints.Builder()
            .setRequiresCharging(true)
            .build()

        val request = OneTimeWorkRequestBuilder<MyWork>()
            .setConstraints(constraints)
            .build()

        binding.btnClick.setOnClickListener {

            WorkManager.getInstance(this).enqueue(request)
        }

        WorkManager.getInstance(this).getWorkInfoByIdLiveData(request.id)
            .observe(this, Observer {

                val status: String = it.state.name
                Toast.makeText(this, status, Toast.LENGTH_SHORT).show()
            })

    }
}