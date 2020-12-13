package com.watsonsoft.messaging.db.entity

import androidx.room.Embedded
import androidx.room.Relation

data class ConversationToMessageToUserRelation(
    @Embedded val conversation: Conversation,
    @Relation(
        entity = Message::class,
        entityColumn = "conversationId",
        parentColumn = "id"
    ) val messageToUserRelations: List<MessageToUserRelation>
)