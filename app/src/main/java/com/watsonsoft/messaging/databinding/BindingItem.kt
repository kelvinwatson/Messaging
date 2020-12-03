package com.watsonsoft.messaging.databinding

import androidx.annotation.LayoutRes

/**
 * Interface for items that should be data bound
 */
interface BindingItem {

    @LayoutRes
    fun getLayout(): Int
}