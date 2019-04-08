package com.boni

import android.app.Application
import com.boni.analytics.Analytics
import com.boni.analytics.firebase.FirebaseTracker
import com.boni.dagger.DaggerAppComponent
import javax.inject.Inject

class App: Application() {

    @Inject
    lateinit var analytics: Analytics

    init {
        DaggerAppComponent
            .builder()
            .build()
            .inject(this)

        setFirebaseTracker()
    }

    private fun setFirebaseTracker() {
        FirebaseTracker(applicationContext, analytics)
    }
}