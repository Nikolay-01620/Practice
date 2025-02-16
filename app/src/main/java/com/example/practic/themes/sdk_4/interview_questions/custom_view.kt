package com.example.practic.themes.sdk_4.interview_questions

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import android.view.ViewTreeObserver

class MyCustomView(context: Context) : View(context) {

    val n = ViewTreeObserver.OnGlobalLayoutListener {

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Устанавливаем цвет для рисования
        val paint = Paint()
        paint.color = Color.RED

        // Рисуем прямоугольник
        canvas.drawRect(100f, 100f, 500f, 500f, paint)

        // Рисуем текст
        paint.color = Color.BLACK
        paint.textSize = 60f
        canvas.drawText("Hello, World!", 150f, 650f, paint)
    }
}
