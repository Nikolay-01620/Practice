package com.example.practic.themes.sdk_4.interview_questions.pagging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.practic.themes.rx_3.practice_block.tasks_2.network_request_1.ApiService

/*
class MyPagingSource(private val apiService: ApiService) : PagingSource<Int, MyData>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MyData> {
        val position = params.key ?: 1 // стартуем с первой страницы
        return try {
            // Замените на реальный запрос к API или БД
            val response = apiService.getPost(position, params.loadSize)
            LoadResult.Page(
                data = response.items, // данные для отображения
                prevKey = null, // предыдущая страница (для пагинации в обратном порядке)
                nextKey = if (response.items.isEmpty()) null else position + 1 // следующая страница
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, MyData>): Int? {
        // Этот метод будет использоваться для определения страницы, на которой произошел сбой
        return state.anchorPosition?.let { state.closestItemToPosition(it)?.id }
    }
}
*/
