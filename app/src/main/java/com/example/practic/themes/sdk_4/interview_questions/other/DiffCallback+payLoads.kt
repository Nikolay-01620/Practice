package com.example.practic.themes.sdk_4.interview_questions.other

fun main() {

}

/*
class MyDiffCallback(private val oldList: List<MyItem>, private val newList: List<MyItem>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size
    override fun getNewListSize(): Int = newList.size

    */
/** Являются ли предметы одинаковыми *//*

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id // Сравниваем по уникальному идентификатору
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition] // Сравниваем содержимое элементов
    }
    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return if (oldItem.likeStatus != newItem.likeStatus) {
            // Передаем только измененный лайк
            "likeChanged"
        } else {
            super.getChangePayload(oldItem, newItem)
        }
    }

}

class MyData1 {

    val likeStatus: Any = TODO()
}

class MyItem {

    val id: Any
        get() {
            TODO()
        }
}
*/
