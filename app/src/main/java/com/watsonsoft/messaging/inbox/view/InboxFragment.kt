package com.watsonsoft.messaging.inbox.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.watsonsoft.messaging.R
import com.watsonsoft.messaging.databinding.BindingAdapter
import com.watsonsoft.messaging.db.entity.Message
import com.watsonsoft.messaging.inbox.InboxItem
import com.watsonsoft.messaging.inbox.InboxViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_inbox.*
import javax.inject.Inject

/**
 * Displays a list of conversations.
 */
@AndroidEntryPoint
class InboxFragment : Fragment() {

    private val viewModel: InboxViewModel by viewModels()

    @Inject
    lateinit var bindingAdapter: BindingAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_inbox, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        with(viewModel) {
            getContent()

        }

        recycler.adapter = bindingAdapter
        val mockList = listOf(
            InboxItem(
                Message(
                    id = 0,
                    timeStamp = 12345L,
                    content = "Some content",
                    senderId = 10150,
                    conversationId = 123
                )
            )
        )
        bindingAdapter.update(mockList)
    }
}