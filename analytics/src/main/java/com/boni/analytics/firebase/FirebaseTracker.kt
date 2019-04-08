package com.boni.analytics.firebase

import android.content.Context
import android.os.Bundle
import android.util.Log
import com.boni.analytics.Analytics
import com.boni.analytics.Event
import com.boni.analytics.Tracker
import com.google.firebase.analytics.FirebaseAnalytics
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class FirebaseTracker @Inject constructor(
    private val context: Context,
    private val analytics: Analytics
) : Tracker<Event, FirebaseEvent> {

    private val compositeDisposable = CompositeDisposable()

    init {
        subscribeToEvents()
    }

    private fun subscribeToEvents() {
        compositeDisposable.add(
            analytics.eventStream
                .map(this::mapTo)
                .subscribe({
                    sendEvent(it)
                }, {
                    logError(it.localizedMessage)
                })
        )
    }

    override fun mapTo(e: Event): FirebaseEvent {
        val firebaseEvent = FirebaseEvent(e.name)

        e.params?.let {
            val bundle = Bundle()

            for (param in it) {
                // you most likely would handle cast errors here
                bundle.putString(param.key, param.value as String)
            }
        }

        return firebaseEvent
    }

    private fun logError(err: String) {
        // do something here, crashlytics or whatever
        Log.i("FirebaseTracker::error", err)
    }

    private fun sendEvent(e: FirebaseEvent) {
        FirebaseAnalytics.getInstance(context).logEvent(e.name, e.params)
    }
}