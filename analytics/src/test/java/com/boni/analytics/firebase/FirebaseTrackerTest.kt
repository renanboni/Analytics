package com.boni.analytics.firebase

import android.content.Context
import com.boni.analytics.Analytics
import com.boni.analytics.EventsStreamProvider
import com.boni.analytics.UserPropertiesStreamProvider
import com.nhaarman.mockitokotlin2.mock
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class FirebaseTrackerTest {

    private val analytics = Analytics()

    private val context = mock<Context>()
    private val eventsStream = mock<EventsStreamProvider>()
    private val userProperty = mock<UserPropertiesStreamProvider>()
    private val firebaseMapper = mock<FirebaseMapper>()


    @Test
    fun whenInitializedShouldSubscribeToEvents() {
        val firebaseTracker = FirebaseTracker(context, analytics, analytics, firebaseMapper)
    }
}