package com.watsonsoft.messaging.inbox.component

import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.watsonsoft.messaging.db.entity.Message

@Composable
fun Inbox(messages: List<Message>) {
    LazyColumnFor(items = messages) { _ ->
        InboxItem()
    }
}

@Preview
@Composable
fun PreviewInbox() {
//    Inbox()
}