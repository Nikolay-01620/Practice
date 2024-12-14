package com.example.practic.theme_1_kotlin.ru_git.task_2_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.practic.databinding.FragmentArcticlesCardsBinding

class ArticlesCardsFragment :
    BaseFragment<FragmentArcticlesCardsBinding, ArticlesCardsViewModel>() {

    private val articlesCardsViewModel: ArticlesCardsViewModel by viewModels()

    override fun initViewModel(): ArticlesCardsViewModel {
        return articlesCardsViewModel
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentArcticlesCardsBinding {
        return FragmentArcticlesCardsBinding.inflate(inflater, container, false)
    }

    override fun setupUI() {
       viewModel.loadArticles()
    }

    override fun setupObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.dataState.collect { state ->
                // handleDataState(state)
                // Логика при успешной загрузке данных
            }
        }
    }
}

