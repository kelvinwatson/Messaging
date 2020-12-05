package com.watsonsoft.messaging.inbox

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.watsonsoft.messaging.db.entity.Message
import com.watsonsoft.messaging.inbox.repository.InboxRepository
import com.watsonsoft.messaging.inbox.view.InboxFragment
import javax.inject.Provider

/**
 * Powers the [InboxFragment]
 */
class InboxViewModel @ViewModelInject constructor(private val repository: Provider<InboxRepository>) :
    ViewModel() {
    private val content by lazy {
        MutableLiveData<LiveData<List<Message>?>>().also {
            repository.get().getContent()
        }
    }

    /**
     * Exposes immutable (read-only) liveData.
     */
    fun getContent(): LiveData<LiveData<List<Message>?>> = content
}