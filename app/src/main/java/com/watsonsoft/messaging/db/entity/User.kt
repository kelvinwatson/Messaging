package com.watsonsoft.messaging.db.entity

import androidx.room.*

@Entity(tableName = "user")
data class User(
    @PrimaryKey val id: Int,
    @ColumnInfo val userName: String,
    @ColumnInfo val avatarUrl: String? = null
)