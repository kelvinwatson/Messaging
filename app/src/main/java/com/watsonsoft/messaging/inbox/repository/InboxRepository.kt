package com.watsonsoft.messaging.inbox.repository

import androidx.lifecycle.liveData
import com.watsonsoft.messaging.db.ConversationDao
import com.watsonsoft.messaging.db.DatabaseHelper
import com.watsonsoft.messaging.db.entity.Conversation
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class InboxRepository @Inject constructor(private val conversationDao: ConversationDao) :
    Repository {
    /**
     * Obtains inbox messages from local storage (e.g. Room database) by default.
     */
    suspend fun getContent(): List<Conversation> {
        val fakeConversation101 = Conversation(101)
        conversationDao.insertConversation(fakeConversation101)
        val fakeConversation102 = Conversation(102)
        conversationDao.insertConversation(fakeConversation102)
        return conversationDao.getAllConversations()
    }
}