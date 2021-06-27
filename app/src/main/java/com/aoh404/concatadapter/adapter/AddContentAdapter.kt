package com.aoh404.concatadapter.adapter

import com.aoh404.concatadapter.R
import com.aoh404.concatadapter.base.BaseDataBindingAdapter

class AddContentAdapter : BaseDataBindingAdapter<String>() {

    override fun getItemByPosition(position: Int): Any? = null

    override fun getLayoutResByPosition(position: Int): Int = R.layout.layout_add_content

    override fun getItemCount(): Int = 1
}