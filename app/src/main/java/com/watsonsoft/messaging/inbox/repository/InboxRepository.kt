package com.watsonsoft.messaging.inbox.repository

import androidx.lifecycle.liveData
import com.watsonsoft.messaging.db.ConversationDao
import com.watsonsoft.messaging.db.DatabaseHelper
import com.watsonsoft.messaging.db.entity.Conversation
import com.watsonsoft.messaging.db.entity.Message
import com.watsonsoft.messaging.db.entity.User
import kotlinx.coroutines.flow.Flow
import java.util.*
import javax.inject.Inject

class InboxRepository @Inject constructor(private val conversationDao: ConversationDao) :
    Repository {
    /**
     * Obtains inbox messages from local storage (e.g. Room database) by default.
     */
    suspend fun getConversations(): List<Conversation> {
        val fakeConversation101 = Conversation(101)
        conversationDao.insertConversation(fakeConversation101)
        val fakeConversation102 = Conversation(102)
        conversationDao.insertConversation(fakeConversation102)

        val usr = User(987, "FakeSender")
        conversationDao.writeUser(usr)
        val msg = Message(123, Date().time, "some fake fake fake content", 101, 987)
        conversationDao.writeMessage(msg)

        return conversationDao.getAllConversations()
    }
}