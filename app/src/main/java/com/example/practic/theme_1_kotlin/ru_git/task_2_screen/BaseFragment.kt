package com.example.practic.theme_1_kotlin.ru_git.task_2_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect

// Абстрактный класс для фрагментов, с поддержкой ViewBinding и ViewModel
abstract class BaseFragment<VB : ViewBinding, VM : ViewModel> : Fragment() {

    // Переменная для ViewBinding
    private var _binding: VB? = null
    protected val binding get() = _binding!!

    // Переменная для ViewModel
    protected lateinit var viewModel: VM

    // Инициализация ViewModel
    abstract fun initViewModel(): VM

    // Инициализация ViewBinding
    abstract fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): VB

    // Настройка UI (например, RecyclerView, кнопки)
    abstract fun setupUI()

    // Настройка наблюдателей LiveData/StateFlow
    abstract fun setupObservers()

    // onCreateView вызывается для инфляции интерфейса фрагмента
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Инициализируем ViewModel
        viewModel = initViewModel()

        // Инициализируем ViewBinding
        _binding = initBinding(inflater, container)

        // Устанавливаем UI элементы
        setupUI()

        // Настроим наблюдателей
        setupObservers()

        return binding.root
    }

    // onDestroyView вызывается для очистки binding
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
