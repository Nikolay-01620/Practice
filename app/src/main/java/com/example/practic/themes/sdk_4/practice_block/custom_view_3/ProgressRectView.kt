package com.example.practic.themes.sdk_4.practice_block.custom_view_3

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import kotlin.random.Random

class ProgressRectView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private var progress = 0f  // Прогресс от 0% до 100%
    private val maxProgress = 100f
    private val paint = Paint()
    private val progressRect = RectF()
    
    // Инициализация случайного цвета
    private val randomColor get() = Color.rgb(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))

    init {
        paint.isAntiAlias = true
        paint.color = randomColor  // Изначальный случайный цвет
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        
        // Отрисовываем сам прямоугольник
        canvas.drawColor(Color.BLUE)  // Цвет фона
        val width = width.toFloat()
        val height = height.toFloat()

        // Задаем область, где будет рисоваться прогресс
        progressRect.set(0f, 0f, width * (progress / maxProgress), height)

        // Отрисовываем заполненную область
        canvas.drawRect(progressRect, paint)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                // Увеличиваем прогресс на 10%
                progress += 10f
                if (progress > maxProgress) {
                    progress = 0f  // Сбрасываем прогресс, если он больше 100%
                }
                // Меняем цвет на случайный
                paint.color = randomColor

                invalidate()  // Перерисовываем вью
            }
        }
        return true
    }
}
