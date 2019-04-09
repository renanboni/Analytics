package com.boni.analytics

import io.reactivex.subjects.PublishSubject

class Analytics: EventsStreamProvider, UserPropertiesStreamProvider {

    override val eventStream = PublishSubject.create<Event>()
    override val userPropertyStream = PublishSubject.create<UserProperty>()

    fun trackEvent(e: Event) {
        eventStream.onNext(e)
    }

    fun trackUserProperty(u: UserProperty) {
        userPropertyStream.onNext(u)
    }
}