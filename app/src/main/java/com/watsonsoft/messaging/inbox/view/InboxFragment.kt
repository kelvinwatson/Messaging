package com.watsonsoft.messaging.inbox.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.watsonsoft.messaging.R
import com.watsonsoft.messaging.db.ConversationDao
import com.watsonsoft.messaging.db.entity.Message
import com.watsonsoft.messaging.inbox.component.Inbox
import com.watsonsoft.messaging.inbox.viewmodel.InboxViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Displays a list of conversations.
 */
@AndroidEntryPoint
class InboxFragment : Fragment() {

    private val viewModel: InboxViewModel by viewModels()

    @Inject
    lateinit var conversationDao: ConversationDao // FAKE

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ComposeView(requireContext()).apply {
        setContent {
            MaterialTheme {
//                Inbox()
                FloatingActionButton(onClick = { fetch() }) {
                    
                }
            }
        }
    }
    
    fun fetch() {
        with(viewModel) {
            getConversationsWithMessagesAndSender().observe(
                viewLifecycleOwner,
                Observer { conversationMessages ->
                    println(conversationMessages) // update state here
                })
        }
    }
}