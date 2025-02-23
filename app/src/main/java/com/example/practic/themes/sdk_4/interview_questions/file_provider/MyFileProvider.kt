package com.example.practic.themes.sdk_4.interview_questions.file_provider

import android.content.Context
import android.net.Uri
import androidx.core.content.FileProvider
import java.io.File

class MyFileProvider : FileProvider() {

    // Метод для генерации URI
    fun shareFile(context: Context, fileName: String, authority: String): Uri? {
        // Получаем путь к файлу
        val filePath = File(context.filesDir, "my_images")
        val file = File(filePath, fileName)

        // Генерируем URI для файла с помощью FileProvider
        return getUriForFile(context, authority, file)
    }
}
