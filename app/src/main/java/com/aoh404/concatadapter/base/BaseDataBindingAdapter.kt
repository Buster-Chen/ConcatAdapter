package com.aoh404.concatadapter.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.*

abstract class BaseDataBindingAdapter<T> : RecyclerView.Adapter<DataBindingViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DataBindingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewDataBinding =
            DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, viewType, parent, false)
        return DataBindingViewHolder(viewDataBinding)
    }

    override fun onBindViewHolder(
        holder: DataBindingViewHolder,
        position: Int
    ) {
        getItemByPosition(position)?.let {
            holder.bind(it)
        }
    }

    override fun getItemViewType(position: Int): Int = getLayoutResByPosition(position)

    protected abstract fun getItemByPosition(position: Int): Any?

    @LayoutRes
    protected abstract fun getLayoutResByPosition(position: Int): Int

}
