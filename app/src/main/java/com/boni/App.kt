package com.boni

import android.app.Application
import com.boni.analytics.Analytics
import com.boni.analytics.firebase.FirebaseMapper
import com.boni.analytics.firebase.FirebaseTracker
import com.boni.dagger.DaggerAppComponent
import javax.inject.Inject

class App: Application() {

    @Inject
    lateinit var analytics: Analytics

    @Inject
    lateinit var firebaseMapper: FirebaseMapper

    init {
        DaggerAppComponent
            .builder()
            .build()
            .inject(this)
    }

    override fun onCreate() {
        super.onCreate()

        FirebaseTracker(
            applicationContext,
            analytics,
            analytics,
            firebaseMapper
        )
    }
}