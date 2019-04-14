package com.boni.analytics.firebase

import android.os.Bundle
import com.boni.analytics.Event
import com.boni.analytics.Mapper

class FirebaseMapper: Mapper<Event, FirebaseEvent> {

    override fun mapFrom(event: Event): FirebaseEvent {
        val firebaseEvent = FirebaseEvent(event.name)

        event.params?.let {
            val bundle = Bundle()

            for (param in it) {
                // you most likely would handle cast errors here
                bundle.putString(param.key, param.value as String)
            }
        }

        return firebaseEvent
    }
}