package com.watsonsoft.messaging.inbox

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.watsonsoft.messaging.R
import com.watsonsoft.messaging.databinding.BindingAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_inbox.*
import javax.inject.Inject

/**
 * Displays a list of conversations.
 */
@AndroidEntryPoint
class InboxFragment : Fragment() {

    @Inject
    lateinit var bindingAdapter: BindingAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_inbox, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recycler.adapter = bindingAdapter
        val mockList = listOf(
            InboxItem("userName", "my message")
        )
        bindingAdapter.update(mockList)
    }
}