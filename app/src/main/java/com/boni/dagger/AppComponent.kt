package com.boni.dagger

import com.boni.App
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class, AnalyticsModule::class])
@Singleton
interface AppComponent {
    fun inject(app: App)
}