package com.watsonsoft.messaging.inbox

import com.watsonsoft.messaging.R
import com.watsonsoft.messaging.databinding.BindingItem

class InboxItem(val userName: String, val messagePreview: String? = null) : BindingItem {
    override fun getLayout() = R.layout.inbox_item
}