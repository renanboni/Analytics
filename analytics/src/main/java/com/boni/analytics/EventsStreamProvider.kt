package com.boni.analytics

import io.reactivex.subjects.PublishSubject

interface EventsStreamProvider {
    val eventStream: PublishSubject<Event>
}