package com.example.practic.themes.sdk_4.practice_block.work_manager_2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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

        /** создаем ограничения с помощью Constraints.Builder()*/
        val constraints = Constraints.Builder()
            /** и указываем ,что задача должна выполняться только в том случае,
             если устройство подключено к зарядке*/
            .setRequiresCharging(true)
            .build()

        /** Билдер ,описывающий задачу для WorkManager.благодаря ему,
        задача будет выполнена единожды */
        val request = OneTimeWorkRequestBuilder<MyWork>()
            .setConstraints(constraints)
            .build()

        binding.btnClick.setOnClickListener {
            WorkManager.getInstance(this)
                /** enqueue(request) добавляет этот запрос в очередь на выполнение.*/
                .enqueue(request)
        }
        /** Получение информации о статусе работы*/
        WorkManager.getInstance(this)
            /** Метод, отслеживающий статус работы,
            идентифицируя её по ID запроса (request.id)*/
            .getWorkInfoByIdLiveData(request.id)

            /** отслеживаем изменения в статусе работы.*/
            .observe(this) {
                val status: String = it.state.name
                Toast.makeText(this, status, Toast.LENGTH_SHORT).show()
            }
    }
}