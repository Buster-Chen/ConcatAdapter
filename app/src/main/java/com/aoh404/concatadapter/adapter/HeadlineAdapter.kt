package com.aoh404.concatadapter.adapter

import androidx.recyclerview.widget.DiffUtil
import com.aoh404.concatadapter.R
import com.aoh404.concatadapter.base.ListDataBindingAdapter

class HeadlineAdapter : ListDataBindingAdapter<String>(ItemCallback()) {

    override fun getItemByPosition(position: Int): String = currentList[position]

    override fun getLayoutResByPosition(position: Int): Int = R.layout.layout_title

    class ItemCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean = true
    }
}