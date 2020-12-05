package com.watsonsoft.messaging.db.entity

import androidx.room.*
import androidx.room.ForeignKey.CASCADE

@Entity(
    tableName = "message",
    foreignKeys = [ForeignKey(
        entity = User::class,
        parentColumns = ["id"],
        childColumns = ["senderId"]
    ), ForeignKey(
        entity = Conversation::class,
        parentColumns = ["id"],
        childColumns = ["conversationId"],
        onDelete = CASCADE
    )]
)
data class Message(

    @PrimaryKey val id: Int,

    @ColumnInfo val timeStamp: Long,

    @ColumnInfo val content: String? = null,

    @ColumnInfo(index = true) val senderId: Int,

    @ColumnInfo(index = true) val conversationId: Int
)