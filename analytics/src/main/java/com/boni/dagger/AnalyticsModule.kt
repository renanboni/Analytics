package com.boni.dagger

import com.boni.analytics.Analytics
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AnalyticsModule {

    @Provides
    @Singleton
    fun provideAnalytics() = Analytics()
}