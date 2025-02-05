package com.example.practic.themes.rx_3.practice_block.task_2.recycler_view_3

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.practic.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.subjects.PublishSubject

// MyFragment.kt
class MyFragment : Fragment() {

    private var itemClickSubject: PublishSubject<Int>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.rx_fragment_recycler, container, false)
    }

    @SuppressLint("CheckResult")
    fun setupObserver(subject: PublishSubject<Int>) {
        itemClickSubject = subject
        itemClickSubject?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe { position ->
                // Показываем Toast с номером позиции
                Toast.makeText(context, "Item at position: $position", Toast.LENGTH_SHORT).show()
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Отписываемся от Subject
        itemClickSubject?.onComplete()
    }
    
    companion object {
        fun newInstance(): MyFragment {
            return MyFragment()
        }
    }
}
