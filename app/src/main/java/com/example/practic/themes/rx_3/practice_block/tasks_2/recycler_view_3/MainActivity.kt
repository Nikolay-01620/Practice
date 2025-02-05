package com.example.practic.themes.rx_3.practice_block.tasks_2.recycler_view_3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practic.R
import io.reactivex.subjects.PublishSubject

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyAdapter
    private val itemClickSubject = PublishSubject.create<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rx_recycler_activity)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val items = List(20) { "Item ${it + 1}" }  // Список из 20 элементов
        adapter = MyAdapter(items, itemClickSubject)
        recyclerView.adapter = adapter

        // Добавляем фрагмент
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, MyFragment.newInstance())
                .commit()
        }
    }

    override fun onStart() {
        super.onStart()
        // Передаем Subject во фрагмент
        val fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as MyFragment
        fragment.setupObserver(itemClickSubject)
    }
}
