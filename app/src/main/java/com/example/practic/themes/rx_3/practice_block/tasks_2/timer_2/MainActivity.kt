package com.example.practic.themes.rx_3.practice_block.tasks_2.timer_2
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.practic.R
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var stopButton: Button
    private lateinit var resetButton: Button
    private lateinit var startButton: Button

    private var timerDisposable: Disposable? = null  // Подписка на таймер
    private var time = 0L  // Храним время
    private var isTimerRunning = false  // Флаг для отслеживания состояния таймера

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rx_timer)

        textView = findViewById(R.id.textView)
        stopButton = findViewById(R.id.stopButton)
        resetButton = findViewById(R.id.resetButton)
        startButton = findViewById(R.id.startButton)

        // Обработчик кнопки Start
        startButton.setOnClickListener {
            if (!isTimerRunning) {  // Проверяем, не запущен ли уже таймер
                startTimer()
                isTimerRunning = true  // Устанавливаем флаг в true
            }
        }

        // Обработчик кнопки Stop
        stopButton.setOnClickListener {
            stopTimer()
        }

        // Обработчик кнопки Reset
        resetButton.setOnClickListener {
            resetTimer()
        }
    }

    private fun startTimer() {
        // Создаем Observable с интервалом 1 секунда, начиная с текущего времени
        timerDisposable = Observable.interval(time, 1, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { elapsedTime ->
                time = elapsedTime
                textView.text = "Time: $time"
            }
    }

    private fun stopTimer() {
        // Останавливаем таймер, если он работает
        timerDisposable?.dispose()
    }

    private fun resetTimer() {
        // Останавливаем таймер
        timerDisposable?.dispose()
        time = 0  // Сбрасываем время
        textView.text = "Time: $time"  // Обновляем текст в TextView
    }

    override fun onDestroy() {
        super.onDestroy()
        // Освобождаем ресурсы и отменяем подписку, если активность уничтожена
        timerDisposable?.dispose()
    }
}

