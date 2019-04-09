package com.boni.dagger

import com.boni.analytics.Analytics
import com.boni.analytics.firebase.FirebaseMapper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AnalyticsModule {

    @Provides
    @Singleton
    fun provideAnalytics() = Analytics()

    @Provides
    @Singleton
    fun providesFirebaseMapper() = FirebaseMapper()
}