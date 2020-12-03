package com.watsonsoft.messaging.databinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import javax.inject.Inject

/**
 * Generic recyclerView adapter that supports data binding.
 */
class BindingAdapter @Inject constructor() : RecyclerView.Adapter<BindingViewHolder>() {

    private var items: List<BindingItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BindingViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            viewType,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        itemAtPosition(position).run {
            holder.bind(this)
        }
    }

    override fun getItemCount() = items.size

    @LayoutRes
    override fun getItemViewType(position: Int): Int = itemAtPosition(position).getLayout()

    fun update(newItems: List<BindingItem>? = null) {
        this.items = newItems ?: emptyList()
        notifyDataSetChanged()
    }

    private fun itemAtPosition(position: Int) = items[position]
}