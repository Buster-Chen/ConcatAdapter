package com.aoh404.concatadapter.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.aoh404.concatadapter.BR

class DataBindingViewHolder(private val viewDataBinding: ViewDataBinding) :
    RecyclerView.ViewHolder(viewDataBinding.root) {

    fun bind(item: Any) {
        viewDataBinding.setVariable(BR.item, item)
        viewDataBinding.executePendingBindings()
    }

}
