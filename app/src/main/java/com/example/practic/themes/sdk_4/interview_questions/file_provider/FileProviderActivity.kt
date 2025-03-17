package com.example.practic.themes.sdk_4.interview_questions.file_provider

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.practic.databinding.FileProviderActivityMainBinding

class FileProviderActivity : AppCompatActivity() {

    private lateinit var binding: FileProviderActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FileProviderActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.shareButton.setOnClickListener {
            // Инициализация провайдера
            val fileProvider = MyFileProvider()

            // Генерируем URI для файла
            val contentUri =
                fileProvider.shareFile(this, "default_image.jpg", "com.mydomain.fileprovider")

            // Проверяем, что URI не null
            if (contentUri != null) {
                val shareIntent = Intent(Intent.ACTION_SEND).apply {
                    putExtra(Intent.EXTRA_STREAM, contentUri)
                    type = "image/jpeg"
                    flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
                }

                // Запускаем intent выбора приложения
                startActivity(Intent.createChooser(shareIntent, "Share image"))
            }
        }
    }
}
