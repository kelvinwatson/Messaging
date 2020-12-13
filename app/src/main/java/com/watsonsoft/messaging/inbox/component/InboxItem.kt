package com.watsonsoft.messaging.inbox.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.watsonsoft.messaging.R

@Composable
fun InboxItem() {
    Row(
        modifier = Modifier.padding(16.dp)
    ) {
        Image(
            imageVector = vectorResource(id = R.drawable.ic_launcher_background),
            modifier = Modifier.size(dimensionResource(id = R.dimen.avatarSize))
        )
        Column {

        }
    }
}

@Preview
@Composable
fun PreviewInboxItem(){
    InboxItem()
}