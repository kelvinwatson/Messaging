package com.watsonsoft.messaging.db

import androidx.room.*
import com.watsonsoft.messaging.db.entity.*
import javax.inject.Inject

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

    @Insert
    fun writeMessage(message: Message)

    @Insert
    fun writeUser(user: User)

    /**
     * Get messages each with their associated user.
     */
    @Transaction
    @Query("SELECT * FROM message")
    fun getMessageSender(): List<MessageToUserRelation>

    /**
     * Get conversations with their associated messages. Each message will have its associated sender.
     */
    @Transaction
    @Query("SELECT * FROM conversation")
    fun getConversationsWithMessagesAndSender(): List<ConversationToMessageToUserRelation>

    @Insert
    fun insertConversation(conversation: Conversation)

    @Delete
    fun deleteConversation(conversation: Conversation)
}