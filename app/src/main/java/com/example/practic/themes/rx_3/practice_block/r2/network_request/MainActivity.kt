package com.example.practic.themes.rx_3.practice_block.r2.network_request

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.practic.R

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var progressBar: ProgressBar

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rx_network_request)

        textView = findViewById(R.id.textView)
        progressBar = findViewById(R.id.progressBar)

        // Показываем прогресс-бар перед запросом
        progressBar.visibility = View.VISIBLE

        // Выполняем сетевой запрос через NetworkUtils
        NetworkUtils.fetchPost(
            callback = { post ->
                progressBar.visibility = View.GONE // Скрываем прогресс-бар
                if (post != null) {
                    textView.text = """
                        User ID: ${post.userId}
                        Post ID: ${post.id}
                        Title: ${post.title}
                        Body: ${post.body}
                    """.trimIndent()
                }
            },
            onError = { error ->
                progressBar.visibility = View.GONE // Скрываем прогресс-бар
                textView.text = error
            }
        )
    }
}
