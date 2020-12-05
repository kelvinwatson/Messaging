package com.watsonsoft.messaging.db.entity

import androidx.room.Embedded
import androidx.room.Relation

/**
 * The sender (user) to message relation is 1:1
 */
data class UserToMessageRelation (
    @Embedded val sender: User,

    @Relation(
        parentColumn = "id", // user id
        entityColumn = "senderId"
    ) val message: Message
)