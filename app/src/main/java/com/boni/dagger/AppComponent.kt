package com.boni.dagger

import com.boni.App
import com.boni.analytics.Analytics
import com.boni.analytics_sample.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class, AnalyticsModule::class])
@Singleton
interface AppComponent {
    fun inject(app: App)
    fun inject(mainActivity: MainActivity)
}