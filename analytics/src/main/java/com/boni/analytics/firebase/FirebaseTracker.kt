package com.boni.analytics.firebase

import android.content.Context
import android.util.Log
import com.boni.analytics.EventsStreamProvider
import com.boni.analytics.UserPropertiesStreamProvider
import com.boni.analytics.UserProperty
import com.google.firebase.analytics.FirebaseAnalytics
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class FirebaseTracker @Inject constructor(
    private val context: Context,
    private val eventsStreamProvider: EventsStreamProvider,
    private val userPropertiesStreamProvider: UserPropertiesStreamProvider,
    private val mapper: FirebaseMapper
) {

    private val compositeDisposable = CompositeDisposable()

    init {
        subscribeToEvents()
        subscribeToUserProperty()
    }

    private fun subscribeToUserProperty() {
        compositeDisposable.add(
            userPropertiesStreamProvider
                .userPropertyStream
                .subscribe({
                    sendUserProperty(it)
                }, {
                    logError(it.localizedMessage)
                })
        )
    }

    private fun subscribeToEvents() {
        compositeDisposable.add(
            eventsStreamProvider
                .eventStream
                .map{ mapper.mapFrom(it) }
                .subscribe({
                    sendEvent(it)
                }, {
                    logError(it.localizedMessage)
                })
        )
    }

    private fun logError(err: String) {
        // do something here, crashlytics or whatever
        Log.i("FirebaseTracker::error", err)
    }

    private fun sendEvent(e: FirebaseEvent) {
        FirebaseAnalytics.getInstance(context).logEvent(e.name, e.params)
    }

    private fun sendUserProperty(u: UserProperty) {
        FirebaseAnalytics.getInstance(context).setUserProperty(u.key, u.key)
    }
}