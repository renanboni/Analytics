package com.boni.analytics_sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.boni.analytics.Analytics
import com.boni.analytics.events.FirstPageEvents
import com.boni.dagger.DaggerAppComponent
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var analytics: Analytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerAppComponent
            .builder()
            .build()
            .inject(this)

        firstButton.setOnClickListener {
            analytics.trackEvent(FirstPageEvents.onFirstButtonClicked())
        }

        secondButton.setOnClickListener {
            analytics.trackEvent(FirstPageEvents.onSecondButtonClicked())
        }
    }
}
