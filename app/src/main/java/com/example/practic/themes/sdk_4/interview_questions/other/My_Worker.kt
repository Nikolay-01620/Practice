package com.example.practic.themes.sdk_4.interview_questions.other


import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkInfo
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.util.UUID

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.)

        // Запуск фоновой работы
        startWork()
    }

    private fun startWork() {
        // Определяем условия, при которых будет выполняться работа
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED) // Работает только при подключении к сети
            .setRequiresCharging(true) // Работает только при зарядке устройства
            .build()

        // Создание WorkRequest с условиями
        val myWorkRequest = OneTimeWorkRequest.Builder(MyWorker::class.java)
            .setConstraints(constraints)
            .build()

        // Получаем WorkManager
        val workManager = WorkManager.getInstance(applicationContext)

        // Добавляем задачу в очередь
        workManager.enqueue(myWorkRequest)

        // Получаем статус работы
        observeWorkStatus(workManager, myWorkRequest.id)
    }

    private fun observeWorkStatus(workManager: WorkManager, workId: UUID) {
        // Получаем статус работы через LiveData
        val statusLiveData: LiveData<WorkInfo> = workManager.getWorkInfoByIdLiveData(workId)
        statusLiveData.observe(this, Observer { workInfo ->
            if (workInfo != null) {
                when (workInfo.state) {
                    WorkInfo.State.SUCCEEDED -> {
                        // Задача выполнена успешно
                        println("Задача выполнена успешно!")
                    }
                    WorkInfo.State.FAILED -> {
                        // Задача не выполнена
                        println("Задача не выполнена!")
                    }
                    else -> {
                        // Задача в процессе выполнения
                        println("Задача в процессе выполнения...")
                    }
                }
            }
        })
    }

    // Определение Worker, который будет выполняться в фоне
    class MyWorker(appContext: Context, workerParams: WorkerParameters) : Worker(appContext, workerParams) {
        override fun doWork(): Result {
            // Имитация фона работы: например, запись в лог или выполнение долгой операции
            println("Задача выполняется в фоне!")

            // Возвращаем успех, если работа выполнена успешно
            return Result.success()
        }
    }
}
