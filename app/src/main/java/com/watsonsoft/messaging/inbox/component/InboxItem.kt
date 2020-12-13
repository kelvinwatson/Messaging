package com.watsonsoft.messaging.inbox.component

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
            modifier = Modifier.padding(start = 16.dp)
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