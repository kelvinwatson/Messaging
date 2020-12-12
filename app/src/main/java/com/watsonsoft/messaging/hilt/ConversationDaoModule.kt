package com.watsonsoft.messaging.hilt

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.watsonsoft.messaging.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ActivityComponent::class)
object ConversationDaoModule {
    @Provides
    fun provideConversationDao(@ApplicationContext context: Context) =
        Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build().conversationDao()
}
