package com.watsonsoft.messaging.db.entity

import androidx.room.Embedded
import androidx.room.Relation

/**
 * Embed a list of messages within the conversation entity. Used to query for entity
 * relationships. In this case, we have one "conversationId" to many Message "id"s.
 */
data class ConversationToMessageRelation(
    @Embedded
    val conversation: Conversation,

    @Relation(
        parentColumn = "id",
        entityColumn = "conversationId",
        entity = Message::class
    ) val messages: List<Message>
)