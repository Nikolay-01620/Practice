package com.example.practic.themes.sdk_4.interview_questions.memory_process

import android.app.ActivityManager
import android.content.Context

import android.app.Activity
import android.os.Bundle
import android.os.Process
import android.widget.Toast
import com.example.practic.databinding.ProcessMemoryInfoActivityMainBinding

class ProcessMemoryInfoActivity : Activity() {

    private lateinit var binding: ProcessMemoryInfoActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ProcessMemoryInfoActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.checkMemoryButton.setOnClickListener {
            // Получаем ActivityManager
            val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

            // Получаем информацию о памяти для текущего процесса (PID текущего приложения)
            val memoryInfoArray = activityManager.getProcessMemoryInfo(intArrayOf(Process.myPid()))

            // Получаем данные о памяти из первого элемента массива
            val memoryInfo = memoryInfoArray[0]

            val totalPss = memoryInfo.totalPss // Общий PSS
            val totalPrivateDirty = memoryInfo.totalPrivateDirty // Приватно использованная память
            val totalSharedDirty = memoryInfo.totalSharedDirty // Разделяемая грязная память

            // Формируем строку для отображения в Toast
            val memoryInfoText = "Total PSS: $totalPss KB\n" +
                    "Private Dirty: $totalPrivateDirty KB\n" +
                    "Shared Dirty: $totalSharedDirty KB"

            // Показываем Toast с информацией о памяти
            Toast.makeText(this, memoryInfoText, Toast.LENGTH_LONG).show()
        }
    }

    // Почищаем кэш приложения
    override fun onDestroy() {
        super.onDestroy()
        clearAppCache()
    }

    private fun clearAppCache() {
        val cacheDir = cacheDir
        cacheDir.deleteRecursively()  // Удаляем все файлы в директории кэша
    }


}
