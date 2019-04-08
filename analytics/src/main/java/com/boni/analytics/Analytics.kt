package com.boni.analytics

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

class Analytics {

    val eventStream = PublishSubject.create<Event>()

    fun getEventStream(): Observable<Event> = eventStream

    fun trackEvent(e: Event) {
        eventStream.onNext(e)
    }
}