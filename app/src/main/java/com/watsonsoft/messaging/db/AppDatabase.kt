package com.watsonsoft.messaging.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.watsonsoft.messaging.db.entity.Conversation
import com.watsonsoft.messaging.db.entity.Message
import com.watsonsoft.messaging.db.entity.User

@Database(entities = [Conversation::class, Message::class, User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun conversationDao(): ConversationDao
}