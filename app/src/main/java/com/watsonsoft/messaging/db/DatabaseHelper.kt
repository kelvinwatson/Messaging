package com.watsonsoft.messaging.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.watsonsoft.messaging.db.entity.Conversation
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Obtain data from room database.
 */
class DatabaseHelper @Inject constructor(private val conversationDao: ConversationDao){
    fun getAllConversations(): List<Conversation> {


        val fakeConversation101 = Conversation(101)
        conversationDao.insertConversation(fakeConversation101)
        val fakeConversation102 = Conversation(102)
        conversationDao.insertConversation(fakeConversation102)

        return conversationDao.getAllConversations()
    }
}
