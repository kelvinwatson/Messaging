package com.watsonsoft.messaging.inbox.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.watsonsoft.messaging.R
import com.watsonsoft.messaging.db.entity.Message

@Composable
fun InboxItem() {
    Row(
        modifier = Modifier.padding(16.dp)
    ) {
        Image(
            imageVector = vectorResource(id = R.drawable.ic_launcher_background),
            modifier = Modifier.clip(shape = CircleShape)
                .size(dimensionResource(id = R.dimen.avatarSize)),
            contentScale = ContentScale.Crop,
        )
        Column(
            modifier = Modifier.padding(start = 16.dp).align(alignment = Alignment.CenterVertically)
        ) {
            Text("Sender username", maxLines = 1, style = TextStyle(fontWeight = FontWeight.Bold))
            Text("Message preview...")
        }
    }
}

@Preview
@Composable
fun PreviewInboxItem() {
    InboxItem()
}