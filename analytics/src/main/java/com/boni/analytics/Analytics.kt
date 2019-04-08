package com.boni.analytics

import io.reactivex.subjects.PublishSubject

class Analytics {

    val eventStream = PublishSubject.create<Event>()
    val userPropertyStream = PublishSubject.create<UserProperty>()

    fun trackEvent(e: Event) {
        eventStream.onNext(e)
    }

    fun trackUserProperty(u: UserProperty) {
        userPropertyStream.onNext(u)
    }
}