package com.watsonsoft.messaging.db.entity

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

/**
 * Entity used to model the conversation SQLite table in the database.
 */
@Entity(tableName = "conversation")
class Conversation constructor(@PrimaryKey val id: Int) {

    @Ignore
    val messages = mutableListOf<Message>()
}