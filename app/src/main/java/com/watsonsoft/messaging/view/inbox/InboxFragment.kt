package com.watsonsoft.messaging.view.inbox

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.watsonsoft.messaging.R
import dagger.hilt.android.AndroidEntryPoint

/**
 * Displays a list of conversations.
 */
@AndroidEntryPoint
class InboxFragment : Fragment() {
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_inbox, container, false)
}