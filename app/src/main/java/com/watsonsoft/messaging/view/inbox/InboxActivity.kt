package com.watsonsoft.messaging.view.inbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.watsonsoft.messaging.R
import dagger.hilt.android.AndroidEntryPoint

/**
 * Container for [InboxFragment].
 */
@AndroidEntryPoint
class InboxActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inbox)
    }
}