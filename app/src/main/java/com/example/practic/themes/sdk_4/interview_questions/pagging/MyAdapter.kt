package com.example.practic.themes.sdk_4.interview_questions.pagging

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil

/*
class MyAdapter : PagingDataAdapter<MyData, MyViewHolder>(MyDataComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        item?.let {
            holder.bind(it)
        }
    }

    companion object {
        val MyDataComparator = object : DiffUtil.ItemCallback<MyData>() {
            override fun areItemsTheSame(oldItem: MyData, newItem: MyData): Boolean {
                return oldItem.id == newItem.id
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: MyData, newItem: MyData): Boolean {
                return oldItem == newItem
            }

            override fun getChangePayload(oldItem: MyData, newItem: MyData): Any? {
                // Если изменился статус лайка, передаем строку с информацией о лайке
                return if (oldItem.likeStatus != newItem.likeStatus) {
                    "likeChanged"
                } else {
                    super.getChangePayload(oldItem, newItem)
                }
            }

        }
    }
}

*/


