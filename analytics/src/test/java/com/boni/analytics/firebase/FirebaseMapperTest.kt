package com.boni.analytics.firebase

import com.boni.analytics.events.FirstPageEvents
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class FirebaseMapperTest {

    private val firebaseMapper = FirebaseMapper()

    @Test
    fun mapFromEventToFirebaseEvent() {
        val event = FirstPageEvents.onFirstButtonClicked()
        val firebaseEvent = firebaseMapper.mapFrom(event)

        assertEquals(event.name, firebaseEvent.name)
        assertEquals(event.params, firebaseEvent.params)
    }
}