package com.boni.analytics

import io.reactivex.subjects.PublishSubject

class Analytics {

    val eventStream = PublishSubject.create<Event>()

    fun trackEvent(e: Event) {
        eventStream.onNext(e)
    }
}