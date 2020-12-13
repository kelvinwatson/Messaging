package com.watsonsoft.messaging.inbox.component

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Inbox() {
    Column {
        InboxItem()
        InboxItem()
        InboxItem()
    }
}

@Preview
@Composable
fun PreviewInbox() {
    Inbox()
}