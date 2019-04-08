package com.boni.analytics.firebase

import android.content.Context
import android.os.Bundle
import android.util.Log
import com.boni.analytics.Analytics
import com.boni.analytics.Event
import com.google.firebase.analytics.FirebaseAnalytics
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class FirebaseTracker @Inject constructor(
    private val context: Context,
    private val analytics: Analytics
) {

    private val compositeDisposable = CompositeDisposable()

    init {
        subscribeToEvents()
    }

    private fun subscribeToEvents() {
        compositeDisposable.add(
            analytics.eventStream
                .map(this::mapToFirebaseEvent)
                .subscribe({
                    sendEvent(it)
                }, {
                    logError(it.localizedMessage)
                })
        )
    }

    private fun mapToFirebaseEvent(e: Event): FirebaseEvent {
        val firebaseEvent = FirebaseEvent(e.name)

        e.params?.let {
            val bundle = Bundle()

            for (param in it) {
                bundle.putString(param.key, param.value as String)
            }
        }

        return firebaseEvent
    }

    private fun logError(err: String) {
        // do something here, crashlytics or whatever
        Log.i("FirebaseTracker::Error", err)
    }

    private fun sendEvent(e: FirebaseEvent) {
        FirebaseAnalytics.getInstance(context).logEvent(e.name, e.params)
    }
}