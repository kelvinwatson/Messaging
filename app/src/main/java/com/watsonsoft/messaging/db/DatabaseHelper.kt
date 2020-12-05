package com.watsonsoft.messaging.db

import com.watsonsoft.messaging.db.entity.Message
import javax.inject.Inject

/**
 * Obtain data from room database.
 */
class DatabaseHelper @Inject constructor(){
    suspend fun getContent(): List<Message>? {
        TODO("Not yet implemented")
    }
}
