package com.watsonsoft.messaging.db

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.watsonsoft.messaging.db.entity.Conversation
import org.junit.After
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.hamcrest.CoreMatchers.`is` as Is

@RunWith(AndroidJUnit4::class)
class ConversationDaoTest {
    lateinit var database: AppDatabase
    lateinit var uut: ConversationDao

    @Before
    fun beforeEach() {
        with(
            Room.inMemoryDatabaseBuilder(
                InstrumentationRegistry.getInstrumentation().targetContext,
                AppDatabase::class.java
            ).build()
        ) {
            database = this
            uut = this.conversationDao()
        }
    }

    @After
    fun afterEach() {
        database.close()
    }

    @Test
    fun verifyInsertion() {
        Conversation(101).run {
            uut.insertConversation(this)
            assertThat(uut.getAllConversations().size, Is(1))
            assertThat(uut.getAllConversations()[0].id, Is(101))
        }
        Conversation(102).run {
            uut.insertConversation(this)
            assertThat(uut.getAllConversations().size, Is(2))
            assertThat(uut.getAllConversations()[1].id, Is(102))
        }
    }

    @Test
    fun verifyGetConversationById() {
        uut.insertConversation(Conversation(101))
        uut.insertConversation(Conversation(102))
        assertThat(uut.getAllConversations().size, Is(2))
        assertThat(uut.getConversationById(101).id, Is(101))
        assertThat(uut.getConversationById(102).id, Is(102))
    }

    @Test
    fun verifyGetConversationMessages() {

    }

    @Test
    fun verifyDeletion() {
        Conversation(101).run {
            uut.insertConversation(this)
            uut.deleteConversation(this)
            assertThat(uut.getAllConversations().size, Is(0))
            uut.deleteConversation(this)
            assertThat(uut.getAllConversations().size, Is(0))
        }
    }

    @Test
    fun verifyDeletionShouldNotCauseCrashWhenDbEmpty() {
        Conversation(101).run {
            uut.deleteConversation(this)
        }
    }
}