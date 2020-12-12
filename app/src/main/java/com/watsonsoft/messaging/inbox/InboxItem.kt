package com.watsonsoft.messaging.inbox

import com.watsonsoft.messaging.R
import com.watsonsoft.messaging.db.entity.Message
import com.watsonsoft.messaging.databinding.BindingItem

class InboxItem(val message: Message) : BindingItem {
    var senderUserName: String? = null
    var preview: String? = null

    init {
        senderUserName = "fakeSenderId"
        preview = message.content
    }

    override fun getLayout() = R.layout.inbox_item
}