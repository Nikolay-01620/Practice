package com.example.practic.themes.sdk_4.interview_questions.file_provider

import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.FileObserver
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.content.FileProvider
import java.io.File

class MyFileProvider : FileProvider() {

    private var fileObserver: FileObserver? = null

    // Метод для генерации URI
    fun shareFile(context: Context, fileName: String, authority: String): Uri? {
        // Получаем путь к файлу
        val filePath = File(context.filesDir, "my_folder")
        val file = File(filePath, fileName)

        // Инициализируем и запускаем FileObserver для отслеживания изменений
        startFileObserver(filePath)

        // Генерируем URI для файла с помощью FileProvider
        return getUriForFile(context, authority, file)
    }



    // Метод для старта FileObserver
    private fun startFileObserver(directory: File) {
        // Создаем FileObserver для указанной директории
        fileObserver = @RequiresApi(Build.VERSION_CODES.Q)

        object : FileObserver(directory, ALL_EVENTS) {

            override fun onEvent(event: Int, path: String?) {
                when (event) {
                    CREATE -> Log.d("FileObserver", "File created: $path")
                    MODIFY -> Log.d("FileObserver", "File modified: $path")
                    DELETE -> Log.d("FileObserver", "File deleted: $path")
                    else -> {}
                }
            }
        }
        // Запускаем наблюдатель
        fileObserver?.startWatching()
    }

    // Метод для остановки наблюдения
    fun stopFileObserver() {
        fileObserver?.stopWatching()
    }
}
