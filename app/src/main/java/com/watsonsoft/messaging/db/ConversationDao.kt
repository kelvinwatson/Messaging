package com.watsonsoft.messaging.db

import androidx.room.*
import com.watsonsoft.messaging.db.entity.Conversation
import com.watsonsoft.messaging.db.entity.ConversationToMessageRelation
import com.watsonsoft.messaging.db.entity.MessageToUserRelation

@Dao
interface ConversationDao {
    @Query("SELECT * FROM conversation")
    fun getAllConversations(): List<Conversation>

    @Query("SELECT * FROM conversation WHERE id = :id")
    fun getConversationById(id: Int): Conversation

    /**
     * Get a conversation's messages.
     */
    @Transaction
    @Query("SELECT * FROM conversation")
    fun getConversationMessages(): List<ConversationToMessageRelation>

    /**
     * Get messages each with their associated user.
     */
    @Transaction
    @Query("SELECT * FROM message")
    fun getMessageSender(): List<MessageToUserRelation>

    @Insert
    fun insertConversation(conversation: Conversation)

    @Delete
    fun deleteConversation(conversation: Conversation)
}