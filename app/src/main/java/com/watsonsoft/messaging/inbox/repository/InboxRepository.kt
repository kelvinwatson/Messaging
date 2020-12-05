package com.watsonsoft.messaging.inbox.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.watsonsoft.messaging.db.entity.Message
import com.watsonsoft.messaging.db.DatabaseHelper
import javax.inject.Inject
import javax.inject.Provider

class InboxRepository @Inject constructor(private val storageHelper: Provider<DatabaseHelper>
) : Repository {
    /**
     * Obtains inbox messages from local storage (e.g. Room database) by default.
     */
    fun getContent(): LiveData<List<Message>?> = liveData {
        val data = storageHelper.get().getContent()
        emit(data)
    }
}