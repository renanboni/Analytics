package com.boni

import android.app.Application
import com.boni.analytics.Analytics
import com.boni.analytics.firebase.FirebaseMapper
import com.boni.analytics.firebase.FirebaseTracker
import com.boni.dagger.AppComponent
import com.boni.dagger.DaggerAppComponent
import javax.inject.Inject

class App: Application() {

    @Inject
    lateinit var analytics: Analytics

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .build()

        appComponent.inject(this)

        FirebaseTracker(
            applicationContext,
            analytics,
            analytics,
            FirebaseMapper()
        )
    }
}