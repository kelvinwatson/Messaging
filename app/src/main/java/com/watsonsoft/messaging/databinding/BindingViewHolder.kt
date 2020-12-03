package com.watsonsoft.messaging.databinding

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.watsonsoft.messaging.BR

/**
 * Generic view holder for all recyclerViews
 */
class BindingViewHolder(private val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: BindingItem) {
        with(binding) {
            setVariable(BR.bindingItem, item)
            executePendingBindings()
        }
    }
}