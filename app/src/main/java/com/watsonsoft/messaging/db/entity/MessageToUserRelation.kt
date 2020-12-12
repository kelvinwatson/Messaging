package com.watsonsoft.messaging.db.entity

import androidx.room.Embedded
import androidx.room.Relation

/**
 * The message to user relation is 1:1 (each message has only one sender).
 */
data class MessageToUserRelation(
    @Embedded val message: Message,

    @Relation(
        entity = User::class,
        entityColumn = "id",  // user id
        parentColumn = "senderId",
    ) val sender: User
)