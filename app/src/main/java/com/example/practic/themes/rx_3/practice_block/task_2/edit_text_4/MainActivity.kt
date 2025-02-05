package com.example.practic.themes.rx_3.practice_block.task_2.edit_text_4

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.practic.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private val textChangeSubject = PublishSubject.create<String>()
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rx_edit_text_activity)

        editText = findViewById(R.id.editText)

        // Слушаем изменения текста в EditText и отправляем данные в PublishSubject
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
                textChangeSubject.onNext(charSequence.toString())  // Отправляем изменения в Subject
            }
            override fun afterTextChanged(editable: Editable?) {}
        })

        // Подписываемся на текстовые изменения и применяем debounce (3 секунды)
        val disposable = textChangeSubject
            .debounce(3, TimeUnit.SECONDS)  // Ждем 3 секунды после последнего ввода
            .observeOn(AndroidSchedulers.mainThread())  // Работаем на главном потоке
            .subscribe { text ->
                // Логируем текст
                Log.d("EditText", "Text after debounce: $text")
            }

        // Добавляем подписку в CompositeDisposable, чтобы управлять ею
        compositeDisposable.add(disposable)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()  // Очищаем подписки при уничтожении активности
    }
}
