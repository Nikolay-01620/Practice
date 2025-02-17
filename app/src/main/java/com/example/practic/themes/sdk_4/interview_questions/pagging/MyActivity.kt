package com.example.practic.themes.sdk_4.interview_questions.pagging

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.example.practic.R
import kotlinx.coroutines.flow.collectLatest

class MyActivity : AppCompatActivity() {

    private lateinit var viewModel: MyViewModel
    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pr)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        adapter = MyAdapter()
        recyclerView.adapter = adapter

        // Получаем ViewModel
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        // Подписываемся на поток данных
        lifecycleScope.launchWhenStarted {
            viewModel.pagingDataFlow.collectLatest { pagingData ->
                adapter.submitData(pagingData) // обновляем данные в адаптере
            }
        }

        // Можно отслеживать состояние загрузки
        adapter.addLoadStateListener { loadState ->
            // handle loading, error states, etc.
            if (loadState.refresh is LoadState.Loading) {
                // Показать индикатор загрузки
            }
        }
    }
}
