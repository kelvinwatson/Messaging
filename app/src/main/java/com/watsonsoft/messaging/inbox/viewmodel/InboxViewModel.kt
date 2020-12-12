package com.watsonsoft.messaging.inbox.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.watsonsoft.messaging.db.entity.Conversation
import com.watsonsoft.messaging.db.entity.ConversationToMessageRelation
import com.watsonsoft.messaging.inbox.repository.InboxRepository
import com.watsonsoft.messaging.inbox.view.InboxFragment
import kotlinx.coroutines.Dispatchers
import javax.inject.Provider

/**
 * Powers the [InboxFragment]
 */
class InboxViewModel @ViewModelInject internal constructor(private val repository: Provider<InboxRepository>) :
    ViewModel() {

    /**
     * Exposes immutable (read-only) liveData.
     */
    fun getConversations() =
        liveData(context = viewModelScope.coroutineContext + Dispatchers.IO) {
            val data = repository.get().getConversations()
            emit(data)
        }

    fun conversationsWithMessages():LiveData<List<ConversationToMessageRelation>> = liveData {

    }
}