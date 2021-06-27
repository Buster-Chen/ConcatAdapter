package com.aoh404.concatadapter.adapter

import androidx.recyclerview.widget.RecyclerView
import com.aoh404.concatadapter.R
import com.aoh404.concatadapter.base.BaseDataBindingAdapter

class TitleAdapter: BaseDataBindingAdapter<String>() {

    var data: String = "Default title"
        set(value) {
            field = value
            notifyItemChanged(0)
        }

    override fun getItemByPosition(position: Int): String = data

    override fun getLayoutResByPosition(position: Int): Int = R.layout.layout_title

    override fun getItemCount(): Int = 1
}