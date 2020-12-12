package com.watsonsoft.messaging.db

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.watsonsoft.messaging.db.entity.Conversation
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
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
    fun verifyInsertion() = runBlocking {

        Conversation(101).run {
            uut.insertConversation(this)
            val listOfListOfConversations = uut.getAllConversations().take(1).toList()
            assertThat(listOfListOfConversations[0].size, Is(1))
            assertThat(listOfListOfConversations[0][0].id, Is(101))
        }
        Conversation(102).run {
            uut.insertConversation(this)
            val listOfListOfConversations = uut.getAllConversations().take(1).toList()
            assertThat(listOfListOfConversations[0].size, Is(2))
            assertThat(listOfListOfConversations[0][1].id, Is(102))
        }
    }

    @Test
    fun verifyGetConversationById() = runBlocking {
        uut.insertConversation(Conversation(101))
        uut.insertConversation(Conversation(102))
        val listOfListOfConversations = uut.getAllConversations().take(1).toList()
        assertThat(listOfListOfConversations[0].size, Is(2))
        assertThat(uut.getConversationById(101).id, Is(101))
        assertThat(uut.getConversationById(102).id, Is(102))
    }

    @Test
    fun verifyGetConversationMessages() {
        uut.insertConversation(Conversation(101))
        assertThat(uut.getConversationById(101).id, Is(101))
        uut.insertConversation(Conversation(102))
        assertThat(uut.getConversationById(102).id, Is(102))
    }

    @Test
    fun verifyDeletion() = runBlocking {
        Conversation(101).run {
            uut.insertConversation(this)
            uut.deleteConversation(this)
            var listOfListOfConversations = uut.getAllConversations().take(1).toList()
            assertThat(listOfListOfConversations[0].size, Is(0))

            uut.deleteConversation(this)
            listOfListOfConversations = uut.getAllConversations().take(1).toList()
            assertThat(listOfListOfConversations[0].size, Is(0))
        }
    }

    @Test
    fun verifyDeletionShouldNotCauseCrashWhenDbEmpty() {
        Conversation(101).run {
            uut.deleteConversation(this)
        }
    }
}