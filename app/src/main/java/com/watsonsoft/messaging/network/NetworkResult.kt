package com.watsonsoft.messaging.network

import com.watsonsoft.messaging.db.entity.Conversation

sealed class NetworkResult
object Loading : NetworkResult()
data class Success(val data: List<Conversation>) : NetworkResult()
data class Error(val exception: Exception) : NetworkResult()