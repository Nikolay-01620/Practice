package com.example.practic.theme_1_kotlin.ru_git.task_2_screen
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.practic.databinding.FragmentArcticlesCardsBinding
import kotlinx.coroutines.launch

/**
 * Фрагмент для отображения списка статей, использующий `ArticlesCardsViewModel` для загрузки данных.
 */
class ArticlesCardsFragment :
    BaseFragment<FragmentArcticlesCardsBinding, ArticlesCardsViewModel>() {

    /** Получаем ViewModel для работы с данными */
    private val articlesCardsViewModel: ArticlesCardsViewModel by viewModels()

    /** Инициализация `ViewModel` */
    override fun initViewModel(): ArticlesCardsViewModel {
        return articlesCardsViewModel
    }

    /** Инициализация `ViewBinding` для связи с XML-разметкой фрагмента */
    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentArcticlesCardsBinding {
        return FragmentArcticlesCardsBinding.inflate(inflater, container, false)
    }

    /** Настройка UI (например, вызов метода загрузки статей) */
    override fun setupUI() {
        viewModel.loadArticles() // Загружаем статьи при создании фрагмента
    }

    /** Настройка наблюдателей для обработки состояний данных */
    override fun setupObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            // Вместо launchWhenStarted используем repeatOnLifecycle
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.dataState.collect { state ->
                    // Логика при изменении состояния данных
                    // Обработка состояний: Loading, Success, Error
                }
            }
        }
    }

}
