package com.boni.analytics.firebase

import com.boni.analytics.Analytics
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class FirebaseTracker @Inject constructor(private val analytics: Analytics) {

    private val compositeDisposable = CompositeDisposable()

    private fun subscribeToEvents() {
        compositeDisposable.add(
            analytics.eventStream
                .subscribe {

                }
        )
    }
}