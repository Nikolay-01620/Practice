package com.example.practic.themes.sdk_4.interview_questions.pagging

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.practic.themes.rx_3.practice_block.tasks_2.network_request_1.ApiService
import kotlinx.coroutines.flow.Flow

/*
class MyViewModel(private val apiService: ApiService) : ViewModel() {

    val pagingDataFlow: Flow<PagingData<MyData>> = Pager(
        config = PagingConfig(
            pageSize = 20, // количество элементов на одну страницу
            enablePlaceholders = false, // можно отключить если не нужно заглушек
            initialLoadSize = 40 // количество элементов для первой загрузки
        ),
        pagingSourceFactory = { MyPagingSource(apiService) }
    ).flow.cachedIn(viewModelScope) // cachedIn позволяет кэшировать данные в течение ViewModel
}
*/
