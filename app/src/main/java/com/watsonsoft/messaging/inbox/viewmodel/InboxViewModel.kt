package com.watsonsoft.messaging.inbox.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.watsonsoft.messaging.db.entity.Conversation
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
    fun getContent(): LiveData<List<Conversation>> =
        liveData(context = viewModelScope.coroutineContext + Dispatchers.IO) {
            val data = repository.get().getContent()
            emit(data)
        }
}